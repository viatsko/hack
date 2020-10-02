/**
 * @param {string} s
 * @return {number}
 */
const maxScore = function(s) {
  let leftZeroes = 0;
  let rightOnes = 0;

  for (const ch of s)
    if (ch === '1')
      rightOnes++;

  let max = 0;

  let left = 0;
  let right = s.length - 1;
  while(left < s.length) {
    if (left > 0) {
      max = Math.max(max, leftZeroes + rightOnes);
    }

    if (s[left] === '0')
      leftZeroes++;
    if (s[left] === '1')
      rightOnes--;
    left++;
  }

  return max;
};
