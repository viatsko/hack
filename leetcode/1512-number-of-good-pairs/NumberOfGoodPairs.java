class Solution {
  // [1, 1] = 1
  // [1, 1, 1] = 3
  // [1, 1, 1, 1] = 6
  // [1, 1, 1, 1, 1] = 10
  // [1, 1, 1, 1, 1, 1] = 15

  // n * (n - 1) / 2
  public int numIdenticalPairs(int[] nums) {
    int[] counts = new int[101];

    for (int i = 0; i < nums.length; i++) {
      counts[nums[i]]++;
    }

    int result = 0;

    for (int i = 1; i < counts.length; i++) {
      result += counts[i] * (counts[i] - 1) / 2;
    }

    return result;
  }
}
