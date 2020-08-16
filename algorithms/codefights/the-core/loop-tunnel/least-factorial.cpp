int leastFactorial(int n) {
  int num = 1;

  for (int i = 1; num < n; i++) {
    num *= i;
  }

  return num;
}
