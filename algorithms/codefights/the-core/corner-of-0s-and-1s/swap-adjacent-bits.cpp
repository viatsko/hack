int swapAdjacentBits(int n) {
  return ((n & 0x55555555) << 1) | ((n & 0xAAAAAAAA) >> 1) ;
}
