function getNthFib(n) {
  return fib(n - 1);
}

function fib(n) {
  if (n <= 1) {
    return n;
  }

  return fib(n - 1) + fib(n - 2);
}

// Do not edit the line below.
exports.getNthFib = getNthFib;
