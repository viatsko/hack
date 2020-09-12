/**
 * @param {number} N
 * @return {number}
 */
const memo = [0, 1, 2];
const climbStairs = function (N) {
  return memo.hasOwnProperty(N)
    ? memo[N]
    : (memo[N] = climbStairs(N - 2) + climbStairs(N - 1));
};
