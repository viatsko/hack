bool increaseNumberRoundness(int n) {
  int rightNonZero = false;

  while (n > 0) {
    int cur = n % 10;

    if (rightNonZero && cur == 0) {
      return true;
    }

    if (cur != 0) {
      rightNonZero = true;
    }

    n /= 10;
  }

  return false;
}
