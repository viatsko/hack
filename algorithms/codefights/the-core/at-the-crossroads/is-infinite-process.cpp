bool isInfiniteProcess(int a, int b) {
  return b > a && (a % 2 != b % 2) || a > b;
}
