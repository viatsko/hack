const singleNonDuplicate = nums => {
    for (let i = 0; i < nums.length; i++) {
        const num = nums[i];

        if (nums[i + 1] !== num) {
            return num;
        }

        while(nums[i + 1] === num) {
            i++;
        }
    }

    return -1;
};
