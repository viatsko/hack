public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int result = 0;
        int j = 0;

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            result++;

            nums[j++] = nums[i];

            while(i < n - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }

        return result;
    }
}
