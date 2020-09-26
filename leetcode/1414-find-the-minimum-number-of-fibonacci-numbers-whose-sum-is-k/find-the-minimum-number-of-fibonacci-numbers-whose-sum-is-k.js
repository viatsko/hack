/**
 * @param {number} k
 * @return {number}
 */
const findMinFibonacciNumbers = function (k) {
  // generate fib sequence
  const fib = [0, 1, 1];
  while (fib[fib.length - 1] <= k) {
    fib[fib.length] = fib[fib.length - 2] + fib[fib.length - 1];
  }

  let result = 0;
  while (k > 0) {
    // while k > 0 substract the next lowest fib number and inc result by 1
    for (let i = fib.length - 1; i >= 2; i--) {
      if (fib[i] <= k) {
        result += 1;
        k -= fib[i];
        break;
      }
    }
  }

  return result;
};
