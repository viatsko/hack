function containsCloseNums(nums, k) {
    const pos = {};
    let found = false;

    for (const i in nums) {
        const num = nums[i];

        if (Object.prototype.hasOwnProperty.call(pos, num)) {
            if (i - pos[num] <= k) {
                found = true;
            }
        }

        pos[num] = i;
    }

    return found;
}
