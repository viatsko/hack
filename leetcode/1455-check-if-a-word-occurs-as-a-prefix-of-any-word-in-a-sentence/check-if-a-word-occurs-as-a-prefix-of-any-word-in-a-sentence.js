/**
 * @param {string} sentence
 * @param {string} searchWord
 * @return {number}
 */
const isPrefixOfWord = function (sentence, searchWord) {
  const words = sentence.split(" ");
  for (let w = 0; w < words.length; w++) {
    const word = words[w];
    if (word.startsWith(searchWord)) {
      return w + 1;
    }
  }

  return -1;
};
