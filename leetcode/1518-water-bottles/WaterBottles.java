class Solution {
  public int numWaterBottles(int numBottles, int numExchange) {
    int res = 0;

    int leftBottles = 0;
    while(numBottles > 0) {
      res += numBottles;
      numBottles += leftBottles;
      leftBottles = numBottles % numExchange;
      numBottles /= numExchange;
    }

    return res;
  }
}
