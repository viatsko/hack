int isSumOfConsecutive2(int n) {
  if (n == 1) {
    return 0;
  }

  int result = 0;

  for (int i = n; i > 0; i--) {
    int summ = n;

    for (int j = i - 1; j > 0; j--) {
      summ -= j;

      if (summ < 0) {
        break;
      } else if (summ == 0) {
        result++;
      }
    }
  }

  return result;
}
