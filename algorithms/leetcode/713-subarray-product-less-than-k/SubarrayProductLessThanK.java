class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) {
            return 0;
        }

        int total = 0;
        int cur = 1;

        int n = nums.length;

        for (int left = 0, right = -1; left < n; left++) {
            // starting to slide to the right
            while (right + 1 < n && cur * nums[right + 1] < k) {
                right++;

                // and multiplying on a way
                cur *= nums[right];
            }

            // elements count
            int tmp = right - left + 1;

            total += tmp > 0 ? tmp : 0;

            // dividing current left keeping sliding window for next iteration
            cur /= nums[left];
        }

        return total;
    }
}

