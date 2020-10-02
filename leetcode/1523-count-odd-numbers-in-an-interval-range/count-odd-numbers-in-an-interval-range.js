/**
 * @param {number} low
 * @param {number} high
 * @return {number}
 */
const countOdds = function(low, high) {
  if (low % 2 === 0) {
    low++;
  }

  if (high % 2 === 0) {
    high--;
  }

  return Math.floor((high - low) / 2) + 1;
};
