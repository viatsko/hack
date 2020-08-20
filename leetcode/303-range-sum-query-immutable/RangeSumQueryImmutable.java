class NumArray {
  private int[] sums;

  public NumArray(int[] nums) {
    int N = nums.length;

    this.sums = new int[N + 1];

    int sum = 0;
    for (int i = 1; i < N + 1; i++) {
      sum += nums[i - 1];
      this.sums[i] = sum;
    }
  }

  public int sumRange(int i, int j) {
    return sums[j + 1] - sums[i];
  }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
