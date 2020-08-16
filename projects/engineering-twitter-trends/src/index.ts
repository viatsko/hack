import nconf from 'nconf';
import { processTweet } from './twitter/TweetsProcessor';
import TwitterStreamer from './twitter/TwitterStreamer'
import { initConfig, setupMongoose, setupTwitter } from './setup';

initConfig();
setupMongoose();

const twitter = setupTwitter();
const twitterStreamer = new TwitterStreamer(
  twitter,
  nconf.get('twitter:hashtags')
);

twitterStreamer.stream(processTweet);
