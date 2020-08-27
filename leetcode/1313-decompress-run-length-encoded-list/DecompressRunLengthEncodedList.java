class Solution {
  public int[] decompressRLElist(int[] nums) {
    List<Integer> result = new ArrayList<>();

    for (int i = 0; i < nums.length - 1; i += 2) {
      int freq = nums[i];
      int val = nums[i + 1];

      while (freq-- > 0) {
        result.add(val);
      }
    }

    return result.stream().mapToInt(i -> i).toArray();
  }
}
