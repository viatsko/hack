import mongoose from 'mongoose';

const TrendsSchema = new mongoose.Schema({
  url: String,
  cnt: Number,
  date: {
    type: Date,
    default: Date.now,
  },
});

export default TrendsSchema;
