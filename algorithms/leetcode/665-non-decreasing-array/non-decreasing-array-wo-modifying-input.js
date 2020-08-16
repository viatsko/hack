const checkPossibility = nums => {
    let count = 0;

    for (let i = 1, prev = nums[0]; i < nums.length; i++) {
        if (nums[i] < prev) {
            if (count++ > 0) {
                return false;
            }

            if (((i - 2) >= 0) && (nums[i - 2] > nums[i])) {
                continue;
            }
        }

        prev = nums[i];
    }

    return true;
};
