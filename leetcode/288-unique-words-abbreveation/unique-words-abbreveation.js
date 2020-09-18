/**
 * @param {string[]} dictionary
 */
const ValidWordAbbr = function(dictionary) {
  this.map = new Map();

  for (const word of dictionary) {
    const hash = this.hash(word);

    if (!this.map.has(hash)) {
      this.map.set(hash, []);
    }

    if (this.map.get(hash).indexOf(word) === -1) {
      this.map.get(hash).push(word);
    }
  }
};

ValidWordAbbr.prototype.hash = function (word) {
  if (word.length <= 2) {
    return word;
  }

  return word[0] + (word.length - 2) + word[word.length - 1];
};

/**
 * @param {string} word
 * @return {boolean}
 */
ValidWordAbbr.prototype.isUnique = function(word) {
  const hash = this.hash(word);

  if (!this.map.has(hash)) {
    return true;
  } else {
    const words = this.map.get(hash);
    if (words.length === 1 && words[0] === word) {
      return true;
    } else {
      return false;
    }
  }
};

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * var obj = new ValidWordAbbr(dictionary)
 * var param_1 = obj.isUnique(word)
 */
