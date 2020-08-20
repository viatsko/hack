/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    private int findPeak(MountainArray mountainArr, int len) {
        int left = 0;
        int right = len - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            //System.out.println("Looking for a peak at " + String.valueOf(mid));
            
            if (mid > 0 && mid < len && mountainArr.get(mid) > mountainArr.get(mid - 1) && mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                return mid;
            } else if (mid == 0 || mountainArr.get(mid) > mountainArr.get(mid - 1)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }
    
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();
        
        int peak = findPeak(mountainArr, len);
        
        if (mountainArr.get(peak) == target) {
            return peak;
        }
        
        int left, right;
        
        // searching in the left side
        left = 0;
        right = peak - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            int current = mountainArr.get(mid);
            
            if (current == target) {
                return mid;
            } else if (current > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        left = peak + 1;
        right = len - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            int current = mountainArr.get(mid);
            
            if (current == target) {
                return mid;
            } else if (current < target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return -1;
    }
}
