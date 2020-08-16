const findDuplicate = nums => {
    for (const num of nums) {
        const absnum = Math.abs(num);

        if (nums[absnum - 1] < 0) {
            return absnum;
        } else {
            nums[absnum - 1] = -nums[absnum - 1];
        }
    }

    return -1;
};
