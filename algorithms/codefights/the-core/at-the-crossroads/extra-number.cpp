int extraNumber(int a, int b, int c) {
  if (a == b) {
    return c;
  } else if (a == c) {
    return b;
  } else {
    return a;
  }
}
