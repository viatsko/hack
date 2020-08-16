const mongoose = require('mongoose');
const PhotoSchema = require('./PhotoSchema');

mongoose.connect('mongodb://localhost/oldstockholm');

const Photo = mongoose.model('Photo', PhotoSchema);

module.exports = {
  mongoose,
  models: {
    Photo,
  },
};
