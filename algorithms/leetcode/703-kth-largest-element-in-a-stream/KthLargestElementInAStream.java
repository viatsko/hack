class KthLargest {
  int[] maxes;
  int k;

  public KthLargest(int k, int[] nums) {
    this.k = k;

    maxes = new int[k + 1];

    for (int i = 0; i < k + 1; i++) {
      maxes[i] = Integer.MIN_VALUE;
    }

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > maxes[k]) {
        maxes[k] = nums[i];

        for (int j = k - 1; j >= 0; j--) {
          if (maxes[j + 1] > maxes[j]) {
            maxes[j + 1] ^= maxes[j];
            maxes[j] ^= maxes[j + 1];
            maxes[j + 1] ^= maxes[j];
          }
        }
      }
    }
  }

  public int add(int val) {
    if (val > maxes[k]) {
      maxes[k] = val;

      for (int j = k - 1; j >= 0; j--) {
        if (maxes[j + 1] > maxes[j]) {
          maxes[j + 1] ^= maxes[j];
          maxes[j] ^= maxes[j + 1];
          maxes[j + 1] ^= maxes[j];
        }
      }
    }

    return maxes[k - 1];
  }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
