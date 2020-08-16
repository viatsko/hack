/**
 * Initialize your data structure here.
 */
var WordDictionary = function() {
  this.root = {};
};

/**
 * Adds a word into the data structure.
 * @param {string} word
 * @return {void}
 */
WordDictionary.prototype.addWord = function(word) {
  let node = this.root;
  for (const char of word) {
    if (!node.hasOwnProperty(char)) {
      node[char] = {};
    }
    node = node[char];
  }

  node['end'] = {};
};

/**
 * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
 * @param {string} word
 * @return {boolean}
 */
WordDictionary.prototype.search = function(
  word,
  position = 0,
  node = undefined
) {
  if (position === word.length && node && node.hasOwnProperty('end')) {
    return true;
  }

  if (!node) {
    node = this.root;
  }

  if (word[position] === '.') {
    const chars = Object.keys(node);

    if (!chars.length) {
      return false;
    }

    let any = false;
    for (const char of chars) {
      if (this.search(word, position + 1, node[char])) {
        any = true;
      }
    }

    return any;
  } else {
    if (!node.hasOwnProperty(word[position])) {
      return false;
    }

    return this.search(word, position + 1, node[word[position]]);
  }
};

/**
 * Your WordDictionary object will be instantiated and called as such:
 * var obj = Object.create(WordDictionary).createNew()
 * obj.addWord(word)
 * var param_2 = obj.search(word)
 */
