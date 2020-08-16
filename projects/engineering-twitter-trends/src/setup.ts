import mongoose from 'mongoose';
import nconf from 'nconf';
import Twit from 'twit';

export function initConfig() {
  nconf.file({ file: 'config.json' }).env([
    'MONGO_URL',
    'TWITTER_CONSUMER_KEY',
    'TWITTER_CONSUMER_SECRET',
    'TWITTER_ACCESS_TOKEN',
    'TWITTER_ACCESS_TOKEN_SECRET',
  ]);
}

export function setupMongoose() {
  mongoose.connect(nconf.get('MONGO_URL'));
}

export function setupTwitter(): Twit {
  return new Twit({
    consumer_key: nconf.get('TWITTER_CONSUMER_KEY'),
    consumer_secret: nconf.get('TWITTER_CONSUMER_SECRET'),
    access_token: nconf.get('TWITTER_ACCESS_TOKEN'),
    access_token_secret: nconf.get('TWITTER_ACCESS_TOKEN_SECRET')
  });
}

