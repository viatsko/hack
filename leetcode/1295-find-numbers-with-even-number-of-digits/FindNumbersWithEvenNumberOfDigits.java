class Solution {
  public int findNumbers(int[] nums) {
    int result = 0;

    for (int num : nums) {
      result += (Math.floor(Math.log10(num)) + 1) % 2 == 0 ? 1 : 0;
    }

    return result;
  }
}
