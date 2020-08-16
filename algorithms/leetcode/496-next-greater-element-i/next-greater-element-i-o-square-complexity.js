const nextGreaterElement = (findNums, nums) => {
    const result = [];

    for (const num of findNums) {
        result[result.length] = -1;

        for (let i = nums.lastIndexOf(num); i < nums.length; i++) {
            if (nums[i] > num) {
                result[result.length - 1] = nums[i];
                break;
            }
        }
    }

    return result;
};
