const findDuplicates = nums => {
    const result = [];

    for (const num of nums) {
        const absnum = Math.abs(num);

        if (nums[absnum - 1] < 0) {
            result.push(absnum)
        } else {
            nums[absnum - 1] = -nums[absnum - 1];
        }
    }

    return result;
};
