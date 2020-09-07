/**
 * @param {string} pattern
 * @param {string} str
 * @return {boolean}
 */
const wordPattern = function (pattern, str) {
  const patterns = {};
  const seen = new Set();

  const words = str.split(" ");

  if (pattern.length !== words.length) {
    return false;
  }

  for (let i = 0; i < pattern.length; i++) {
    if (!patterns[pattern[i]]) {
      if (seen.has(words[i])) {
        return false;
      }

      patterns[pattern[i]] = words[i];
      seen.add(words[i]);
    }

    if (patterns[pattern[i]] !== words[i]) {
      return false;
    }
  }

  return true;
};
