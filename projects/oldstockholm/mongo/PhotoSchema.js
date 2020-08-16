const { Schema } = require('mongoose');

const PhotoSchema = new Schema({
  image: String,
  dateString: String,
  title: String,
  url: String,
  postId: Number,
});

module.exports = PhotoSchema;
