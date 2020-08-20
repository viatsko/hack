class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        /*
            from description we know number should appear
            more than N/2 times in an array of length N,
            which means we can do 2 binary searches in two halves of the array
        */
        int pivot = nums.length / 2;
        
        int lower = -1;
        int higher = -1;
        
        int left = 0, right = pivot, mid = -1;
        while (left <= right) {
            mid = (right - left) / 2 + left;
            
            if (nums[mid] == target) {
                lower = mid;
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (lower == -1) {
            return false;
        }
        
        left = pivot;
        right = nums.length - 1;
        while (left <= right) {
            mid = (right - left) / 2 + left;
            
            if (nums[mid] == target) {
                higher = mid;
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (higher == -1) {
            return false;
        }
        
        return (higher - lower + 1) > (nums.length / 2);
    }
}
