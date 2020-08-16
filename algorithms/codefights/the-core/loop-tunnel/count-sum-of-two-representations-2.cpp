int countSumOfTwoRepresentations2(int n, int l, int r) {
  int result = 0;

  for (int i = l; i <= (n / 2); i++) {
    int a = i;

    int b = n - a;

    if (b >= l && b <= r) {
      result++;
    }
  }

  return result;
}
