int squareDigitsSequence(int num) {
  int n = num;

  int result = 1;

  std::set<int> prev;

  while (true) {
    prev.insert(n);

    int new_n = 0;

    while (n > 0) {
      int a = n % 10;

      n /= 10;

      new_n += a * a;
    }

    n = new_n;

    result++;

    if (prev.find(n) != prev.end()) {
      return result;
    }
  }
}
