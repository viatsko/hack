int rangeBitCount(int a, int b) {
  int result = 0;

  for (int i = a; i <= b; i++) {
    result += __builtin_popcount(i);
  }

  return result;
}
