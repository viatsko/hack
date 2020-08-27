// 1 2 3 4 5 6 7 8 9
class Solution {
  public int maxCoins(int[] piles) {
    Arrays.sort(piles);

    int result = 0;

    for (int i = 0; i < piles.length / 3; i++) {
      result += piles[piles.length - 2 - i * 2];
    }

    return result;
  }
}
