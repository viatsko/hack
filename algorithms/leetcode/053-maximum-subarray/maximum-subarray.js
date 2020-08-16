const maxSubArray = nums => {
    if (!nums || !Array.isArray(nums) || !nums.length) {
        return 0;
    }

    let max = nums[0];
    let sum = nums[0];

    for (let i = 1; i < nums.length; i++) {
        if (sum < 0) {
            sum = 0;
        }

        sum += nums[i];

        max = Math.max(sum, max);
    }

    return max;
};
