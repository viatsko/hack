int mirrorBits(int a) {
  int result = 0;

  while (a) {
    result = (result << 1) | (a & 1);
    a >>= 1;
  }

  return result;
}
