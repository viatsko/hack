/**
 * @param {number[]} s
 * @param {number} k
 * @return {number}
 */
const subarraysWithKDistinct = function (s, k) {
  return helper(s, k) - helper(s, k - 1);
};

const helper = function (s, k) {
  let result = 0;

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

    result += windowEnd - windowStart + 1;
  }

  return result;
};
