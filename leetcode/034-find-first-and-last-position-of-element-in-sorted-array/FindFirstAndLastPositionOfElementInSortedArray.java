class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{
            first(nums, nums.length, 0, nums.length - 1, target),
            last(nums, nums.length, 0, nums.length - 1, target)
        };
    }
    
    private int first(int[] nums, int n, int low, int high, int target) {
        if (high >= low) {
            int mid = low + (high - low) / 2;
            
            if (nums[mid] == target && (mid == 0 || nums[mid - 1] < target)) {
                return mid;
            } else if (nums[mid] < target) {
                return first(nums, n, (mid + 1), high, target);
            } else {
                return first(nums, n, low, (mid - 1), target);
            }
        }        
        
        return -1;
    }
    
    private int last(int[] nums, int n, int low, int high, int target) {
        if (high >= low) {
            int mid = low + (high - low) / 2;
            
            if (nums[mid] == target && (mid == n - 1 || nums[mid + 1] > target)) {
                return mid;
            } else if (nums[mid] > target) {
                return last(nums, n, low, (mid - 1), target);
            } else {
                return last(nums, n, (mid + 1), high, target);
            }
        }
        
        return -1;
    }
}
