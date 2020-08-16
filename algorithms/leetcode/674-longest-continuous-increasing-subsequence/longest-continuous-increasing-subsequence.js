const findLengthOfLCIS = nums => {
    let max = 0;
    for (let i = 0; i < nums.length; i++) {
        let len = 1;

        while (i < nums.length && nums[i] < nums[i + 1]) {
            len++;
            i++;
        }

        max = Math.max(max, len);
    }

    return max;
};
