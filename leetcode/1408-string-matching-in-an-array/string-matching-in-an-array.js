const countSubStr = function (haystack, needle) {
  let count = 0;
  let index = haystack.indexOf(needle);
  while (index > -1) {
    count++;
    index = haystack.indexOf(needle, index + 1);
  }
  return count;
};

/**
 * @param {string[]} words
 * @return {string[]}
 */
const stringMatching = function (words) {
  const result = [];
  const str = words.join(" ");
  for (const word of words) {
    if (countSubStr(str, word) >= 2) {
      result.push(word);
    }
  }
  return result;
};
