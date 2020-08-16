int magicalWell(int a, int b, int n) {
  int result = 0;

  for (int i = 0; i < n; i++, a++, b++) {
    result += a * b;
  }

  return result;
}
