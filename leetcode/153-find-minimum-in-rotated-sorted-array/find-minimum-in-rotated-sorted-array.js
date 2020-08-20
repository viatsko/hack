
const findMin = nums => {
    if (!nums || !Array.isArray(nums) || !nums.length) {
        return -1;
    }
    
    if (nums.length === 1) {
        return nums[0];
    }
    
    let min = 0;
    let max = nums.length - 1;
    
    while(min <= max) {
        let mid = Math.floor((max + min) / 2);
        
        if (mid > 0 && nums[mid] < nums[mid - 1]) {
            return nums[mid];
        }
        
        if (nums[min] <= nums[mid] && nums[mid] > nums[max]) {
            min = mid + 1;
        } else {
            max = mid - 1;
        }
    }
    
    return nums[min];
}
