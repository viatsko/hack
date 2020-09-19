/**
 * @param {string} s
 * @return {number}
 */
const lengthOfLongestSubstringTwoDistinct = function (s) {
  let maxLength = 0;

  const freq = new Map();

  let windowStart = 0;
  for (let windowEnd = 0; windowEnd < s.length; windowEnd++) {
    let rightChar = s[windowEnd];

    freq.set(rightChar, (freq.get(rightChar) || 0) + 1);

    while (freq.size > 2) {
      let leftChar = s[windowStart];

      freq.set(leftChar, freq.get(leftChar) - 1);
      if (freq.get(leftChar) === 0) {
        freq.delete(leftChar);
      }

      windowStart++;
    }

    maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
  }

  return maxLength;
};
