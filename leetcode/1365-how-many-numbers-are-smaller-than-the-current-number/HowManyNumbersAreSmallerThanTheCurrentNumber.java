class Solution {
  public int[] smallerNumbersThanCurrent(int[] _nums) {
    //Arrays.sort(nums);
    int[] nums = Arrays.stream(_nums).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();

    int[] counts = new int[101];

    int[] result = new int[nums.length];

    for (int i = 0; i < nums.length; i++) {
      while (i < (nums.length - 1) && nums[i] == nums[i + 1]) {
        i++;
      }

      counts[nums[i]] = nums.length - i - 1;
    }

    for (int i = 0; i < nums.length; i++) {
      result[i] = counts[_nums[i]];
    }

    return result;
  }
}
