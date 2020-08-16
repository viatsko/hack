import TrendsModel from '../mongoose/models/TrendsModel';
import TweetsModel from '../mongoose/models/TweetsModel';

import { expandUrl } from '../utils/UrlExpander';

async function storeTweetObject(tweet: any) {
  const tweetObject = new TweetsModel({
    tweet,
  });

  await tweetObject.save();
}

async function processUrls(urls: any) {
  for (const url of urls) {
    if (!url.expanded_url || (url.expanded_url.indexOf('twitter.com') !== -1)) {
      continue;
    }

    console.log(`Processing ${url.expanded_url}...`);

    let expandedUrl;

    try {
      expandedUrl = await expandUrl(url.expanded_url);

      // https://javascriptkicks.com/r/8334?url=

      if (expandedUrl.indexOf('javascriptkicks.com') !== -1) {
        expandedUrl = expandedUrl.split('=');

        // safety measures
        if (!expandedUrl || expandedUrl.length <= 1) {
          continue;
        }

        expandedUrl = expandedUrl[1];
      }

      const trendsObject = await TrendsModel.findOneAndUpdate(
        { url: expandedUrl },
        { $inc: { cnt: 1 }, date: Date.now() },
        { new: true }
      );

      if (trendsObject) {
        await trendsObject.save();
      } else {
        await new TrendsModel({
          url: expandedUrl,
          cnt: 1,
          date: Date.now(),
        }).save();
      }
    } catch (e) {
      console.error(e);
    }

    console.log(`DONE Processing ${url.expanded_url}${expandedUrl ? (` -> ${expandedUrl}`) : ''}`);
  }
}

export async function processTweet(tweet: any) {
  await storeTweetObject(tweet);

  if (tweet.entities && tweet.entities.urls) {
    await processUrls(tweet.entities.urls);
  }
}
