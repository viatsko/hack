function getNthFib(n) {
  return fib(n - 1);
}

const fibMemo = {};
function fib(n) {
  if (n <= 1) {
    return n;
  }

  if (fibMemo[n] !== undefined) {
    return fibMemo[n];
  }

  return (fibMemo[n] = fib(n - 1) + fib(n - 2));
}

// Do not edit the line below.
exports.getNthFib = getNthFib;
