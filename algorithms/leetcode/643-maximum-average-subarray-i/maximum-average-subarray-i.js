
const findMaxAverage = (nums, k) => {
    let sum = 0;
    let max = Number.NEGATIVE_INFINITY;
    
    for (let i = 0; i < k && i < nums.length; i++) {
        sum += nums[i];
    }
    
    max = sum / (Math.min(k, nums.length));
    
    for (let i = k; i < nums.length; i++) {
        sum += (nums[i] - nums[i - k]);
        
        max = Math.max(sum / k, max);
    }
    
    return max;
}
