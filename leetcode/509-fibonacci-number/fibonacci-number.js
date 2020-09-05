/**
 * @param {number} N
 * @return {number}
 */
var fib = function (N) {
  let sum = 0;
  const stack = [];
  stack.push(N);

  while (stack.length > 0) {
    const val = stack.pop();

    if (val === 0) {
      sum += 0;
    } else if (val === 1) {
      sum += 1;
    } else {
      stack.push(val - 2);
      stack.push(val - 1);
    }
  }

  return sum;
};
