const canPartitionKSubsets = (nums, k) => {
    if (nums.length < k) {
        return false;
    }

    let bigSum = 0;

    for (let i = 0; i < nums.length; i++) {
        bigSum += nums[i];
    }

    if (bigSum % k !== 0) {
        return false;
    }

    const groupSum = bigSum / k;

    for (let i = 0; i < nums.length; i++) {
        if (nums[i] > groupSum) {
            return false;
        }
    }

    nums.sort((a, b) => b - a);

    const seqs = new Array(k).fill(null).map(() => []);

    let used = new Array(nums.length).fill(false);
    const backtrack = (result, target, startIndex) => {
        if (target === 0) {
            return true;
        }

        for (let i = startIndex; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            result.push(nums[i]);

            if (backtrack(result, target - nums[i], i + 1)) {
                used[i] = true;
                return true;
            }

            result.pop();
        }

        return false;
    };

    for (let i = 0; i < k; i++) {
        if (!backtrack(seqs[i], groupSum, 0)) {
            return false;
        }
    }

    return true;
};
