const numSubarrayProductLessThanK = (nums, k) => {
    if (k === 0) {
        return 0;
    }

    let total = 0;
    let cur = 1;

    // for each left till the end of array
    for (let left = 0, right = -1; left < nums.length; left++) {
        // starting to slide to the right
        while (right + 1 < nums.length && cur * nums[right + 1] < k) {
            right++;

            // and multiplying on a way
            cur *= nums[right];
        }

        // elements count
        let tmp = right - left + 1;

        total += tmp > 0 ? tmp : 0;

        // dividing current left keeping sliding window for next iteration
        cur /= nums[left];
    }

    return total;
};
