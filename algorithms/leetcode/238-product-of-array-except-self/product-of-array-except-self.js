
const productExceptSelf = nums => {
    const result = [1];

    for (let i = 1; i < nums.length; i++) {
        result.push(result[i - 1] * nums[i - 1]);
    }

    for (let i = nums.length - 1, add = 1; i >= 0; i--) {
        result[i] *= add;
        add *= nums[i];
    }

    return result;
}
