class Solution {
  public void sortColors(int[] nums) {
      int N = nums.length;

      int start = 0;
      int end = N - 1;

      for (int i = 0; i <= end; i++) {
          if (nums[i] == 0) {
              if (i != start) {
                  swap(nums, start, i);
              }
              start++;
          } else if (nums[i] == 2) {
              if (i != end) {
                  swap(nums, i, end);
              }
              end--;
              i--;
          }
      }
  }

  private void swap(int[] nums, int i, int j) {
      nums[i] ^= nums[j];
      nums[j] ^= nums[i];
      nums[i] ^= nums[j];
  }
}
