import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;

        int[] nums = new int[length];

        System.arraycopy(nums1, 0, nums, 0, nums1.length);

        System.arraycopy(nums2, 0, nums, nums1.length, nums2.length);

        Arrays.sort(nums);

        if (length % 2 == 1) {
            return nums[length / 2];
        } else {
            return (double) (nums[length / 2 - 1] + nums[length / 2]) / 2;
        }
    }
}
