int appleBoxes(int k) {
  int result = 0;

  for (int i = 1; i <= k; i++) {
    result += (i % 2 == 0 ? i * i : -i * i);
  }

  return result;
}
