import mongoose from 'mongoose';

const TweetSchema = new mongoose.Schema({
  tweet: Object,
  date: {
    type: Date,
    default: Date.now,
  },
});

export default TweetSchema;
