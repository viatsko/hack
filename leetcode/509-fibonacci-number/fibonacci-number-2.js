/**
 * @param {number} N
 * @return {number}
 */
const memo = [0, 1];
const fib = function (N) {
  return memo.hasOwnProperty(N) ? memo[N] : (memo[N] = fib(N - 2) + fib(N - 1));
};
