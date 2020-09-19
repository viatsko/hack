/**
 * @param {number[]} calories
 * @param {number} k
 * @param {number} lower
 * @param {number} upper
 * @return {number}
 */
const dietPlanPerformance = function (calories, k, lower, upper) {
  let result = 0;

  let windowStart = 0;
  let windowEnd = 0;
  let sum = 0;
  for (windowEnd = 0; windowEnd < calories.length; windowEnd++) {
    sum += calories[windowEnd];

    if (windowEnd >= k - 1) {
      if (sum < lower) {
        result -= 1;
      } else if (sum > upper) {
        result += 1;
      }
      sum -= calories[windowStart++];
    }
  }

  return result;
};
