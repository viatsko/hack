class Solution {
  public List<Integer> minSubsequence(int[] nums) {
    Arrays.sort(nums);

    int total = Arrays.stream(nums).sum();

    List<Integer> result = new ArrayList<>();

    int current = 0;
    for (int i = 0; i < nums.length; i++) {
      if (current <= total - current) {
        current += nums[nums.length - i - 1];
        result.add(nums[nums.length - i - 1]);
      }
    }
    return result;
  }
}
