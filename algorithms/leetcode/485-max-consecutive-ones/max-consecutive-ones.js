const findMaxConsecutiveOnes = nums => {
    let max = 0;

    for (let i = 0; i < nums.length; i++) {
        if (nums[i] === 1) {
            let count = 1;

            while(nums[i + 1] === 1) {
                count++;
                i++;
            }

            max = Math.max(count, max);
        }
    }

    return max;
};
