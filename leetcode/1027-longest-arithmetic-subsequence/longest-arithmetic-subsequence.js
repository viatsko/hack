/**
 * @param {number[]} A
 * @return {number}
 */
var longestArithSeqLength = function (A) {
  const dp = [];

  let result = 2;

  for (let j = 0; j < A.length; j++) {
    dp[j] = [];
    for (let i = 0; i < j; i++) {
      const diff = A[j] - A[i];

      dp[j][diff] = (dp[i][diff] || 1) + 1;

      result = Math.max(result, dp[j][diff]);
    }
  }

  return result;
};
