const longestConsecutive = nums => {
    const s = new Set(nums);
    let max = 0;

    for (const num of nums) {
        if (!s.contains(num - 1)) {
            let current = num;
            let l = 1;

            while (s.contains(++current)) {
                l++;
            }

            max = Math.max(max, count);
        }
    }

    return max;
};
