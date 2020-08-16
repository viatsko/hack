import Twit from 'twit';

export default class TwitterStreamer {
  _hashtags: string[];
  _twitter: Twit;

  constructor(twitter: Twit, hashtags: string[]) {
    this._twitter = twitter;
    this._hashtags = hashtags;
  }

  stream(callback: any) {
    const stream = this._twitter.stream('statuses/filter', {
      track: this._hashtags,
    });

    stream.on('tweet', callback);
  }
}
