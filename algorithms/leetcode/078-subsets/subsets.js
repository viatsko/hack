const subsets = nums => {
    const result = [];
    const tmp = [];

    const bt = (start) => {
        result.push(tmp.slice(0));

        for (let i = start; i < nums.length; i++) {
            tmp.push(nums[i]);

            bt(i + 1);

            tmp.pop();
        }
    };

    bt(0);

    return result;
};
