public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // max num in an array is always = n max
        // discussion https://discuss.leetcode.com/topic/315/why-most-people-solve-this-problem-under-the-assumption-a-i-n/5
        for (int i = 0; i < n; i++) {
            int index = nums[i] - 1;

            while(
                    nums[i] > 0 &&
                    nums[i] <= n && // (nums[i] = n) -1 max index
                    nums[index] != nums[i]
            ) {
                nums[i] ^= nums[index];
                nums[index] ^= nums[i];
                nums[i] ^= nums[index];

                index = nums[i] - 1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }
}
