class Solution {
  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    int N = flowerbed.length;

    if (n == 0) {
      return true;
    }

    if (N == 0) {
      return false;
    }

    if (N == 1) {
      if (flowerbed[0] == 0 && n > 0) {
        return true;
      }

      return false;
    }

    if (flowerbed[0] == 0 && flowerbed[1] == 0) {
      flowerbed[0] = 1;
      n--;
    }

    if (flowerbed[N - 1] == 0 && flowerbed[N - 2] == 0) {
      flowerbed[N - 1] = 1;
      n--;
    }

    for (int i = 1; i < flowerbed.length - 1; i++) {
      if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
        flowerbed[i] = 1;
        n--;
      }
    }

    return n <= 0;
  }
}
