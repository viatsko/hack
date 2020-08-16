class Solution {
    private int findOffset(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        if (nums[right] >= nums[left]) {
            return 0;
        }
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if(mid > 0 && nums[mid] < nums[mid - 1]) {
                return mid;
            } else if (nums[right] < nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return 0;
    }
    
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int offset = findOffset(nums);
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int offsetMid = (mid + offset) % n;
            
            if (nums[offsetMid] == target) {
                return offsetMid;
            } else if (nums[offsetMid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return -1;
    }
}
