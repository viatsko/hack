class Solution {
  public int findMaxLength(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        nums[i] = -1;
      }
    }

    Map<Integer, Integer> map = new HashMap<>();

    int max = 0;
    int cur = 0;

    for (int i = 0; i < nums.length; i++) {
      cur += nums[i];

      Integer mapSum = map.get(cur);
      if (mapSum != null) {
        max = Math.max(max, i - mapSum);
      } else if (cur == 0) {
        max = i + 1;
      } else {
        map.put(cur, i);
      }
    }

    return max;
  }
}
