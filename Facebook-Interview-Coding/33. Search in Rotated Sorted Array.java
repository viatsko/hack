33. Search in Rotated Sorted Array

public int search(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left < right) { // find min idx, when left == right return left
        int mid = left + (right - left) / 2;
        if (nums[mid] > nums[right])
            left = mid + 1;
        else    right = mid;
    }
    if (target == nums[left])   return left; // performance improved
    int rotate = left; 
    left = 0;
    right = nums.length - 1;
    while (left <= right) { // = return
        int mid = left + (right - left) / 2;
        int newMid = (mid + rotate) % nums.length;
        if (target < nums[newMid])  right = mid - 1;
        else if (target > nums[newMid])   left = mid + 1;
        else    return newMid;
    }
    return -1;
}

public int search(int[] nums, int target) {        
    int left = 0, right = nums.length - 1;
    while (left <= right) { // must find right idx within this loop : =
        int mid = (left + right) / 2;
        if (nums[mid] == target)   return mid;
        else if (nums[mid] < nums[right])
            if (nums[mid] < target && nums[right] >= target)
                left = mid + 1;
            else    right = mid - 1;
        else
            if (nums[left] <= target && target < nums[mid])
                right = mid - 1;
            else    left = mid + 1;
    }
    return -1;
}