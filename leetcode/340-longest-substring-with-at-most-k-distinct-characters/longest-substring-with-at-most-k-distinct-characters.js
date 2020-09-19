/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
const lengthOfLongestSubstringKDistinct = function (s, k) {
  let maxLength = 0;

  const freq = new Map();

  let windowStart = 0;
  for (let windowEnd = 0; windowEnd < s.length; windowEnd++) {
    let rightChar = s[windowEnd];

    freq.set(rightChar, (freq.get(rightChar) || 0) + 1);

    while (freq.size > k) {
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
