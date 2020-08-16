int s(int n) {
  int result = 0;

  while (n > 0) {
    result += n % 10;
    n /= 10;
  }

  return result;
}

int comfortableNumbers(int l, int r) {
  int result = 0;

  for (int a = l; a <= r; a++) {
    for (int b = a + 1; b <= r; b++) {
      int summ_a = s(a);
      int summ_b = s(b);

      if (
        b >= (a - summ_a) &&
        b <= (a + summ_a) &&
        a >= (b - summ_b) &&
        a <= (b + summ_b)
      ) {
        result++;
      }
    }
  }

  return result;
}
