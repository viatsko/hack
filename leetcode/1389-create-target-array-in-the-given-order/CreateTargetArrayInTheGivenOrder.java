class Solution {
  public int[] createTargetArray(int[] nums, int[] index) {
    List<Integer> result = new LinkedList<>();
    for (int i = 0; i < nums.length; i++) {
      result.add(index[i], nums[i]);
    }
    return result.stream().mapToInt(i -> i).toArray();
  }
}
