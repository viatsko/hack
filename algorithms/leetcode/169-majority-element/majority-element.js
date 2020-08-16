const majorityElement = nums => {
    const counts = {};
    const find = nums.length / 2;

    for (const num of nums) {
        counts[num] = -~counts[num];

        if (counts[num] > find) {
            return num;
        }
    }

    return -1;
};
