const removeElement = (nums, val) => {
    let j = 0;

    for (let i = 0; i < nums.length; i++) {
        if (nums[i] !== val) {
            nums[j++] = nums[i];
        }
    }

    return j;
};
