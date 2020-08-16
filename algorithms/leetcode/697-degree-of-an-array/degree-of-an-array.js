const findShortestSubArray = nums => {
    if (nums.length === 0) {
        return 0;
    }

    const counts = {};

    let max = 0;
    for (let i = 0; i < nums.length; i++) {
        const num = nums[i];

        if (!counts[num]) {
            counts[num] = {
                count: 1,
                index: i,
                lastIndex: i
            };
        } else {
            counts[num].count++;
            counts[num].lastIndex = i;
        }

        max = Math.max(counts[num].count, max);
    }

    let min = Number.POSITIVE_INFINITY;

    for (const num in counts) {
        if (counts[num].count === max) {
            min = Math.min(min, counts[num].lastIndex - counts[num].index + 1);
        }
    }

    return min;
};
