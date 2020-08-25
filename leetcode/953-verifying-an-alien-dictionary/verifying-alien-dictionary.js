/**
 * @param {string[]} words
 * @param {string} order
 * @return {boolean}
 */
var isAlienSorted = function(words, order) {
  const origWords = [...words];

  const dict = {};
  for (let i = 0; i < order.length; i++) {
    dict[order[i]] = i;
  }

  words.sort((a, b) => {
    for (let i = 0; i < a.length && i < b.length; i++) {
      if (a[i] !== b[i]) {
        return dict[a[i]] - dict[b[i]];
      }
    }

    return a.length - b.length;
  });

  for (let i = 0; i < words.length; i++) {
    if (words[i] !== origWords[i]) {
      return false;
    }
  }

  return true;
};
