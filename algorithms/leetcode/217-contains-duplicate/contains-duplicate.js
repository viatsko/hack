const containsDuplicate = nums => {
    if (!nums || !Array.isArray(nums) || !nums.length) {
        return false;
    }
    
    nums.sort();
    
    for (let i = 1; i < nums.length; i++) {
        if (nums[i] === nums[i - 1]) {
            return true;
        }
    }
    
    return false;
}
