public class RotateArray {
    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];

            i++;
            j--;
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int index = k % n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, index - 1);
        reverse(nums, index, n - 1);
    }
}
