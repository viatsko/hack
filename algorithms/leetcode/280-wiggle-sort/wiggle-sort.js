
const wiggleSort = nums => {
    nums.sort((a, b) => b - a);

    for(let i = 0; i < nums.length - 1; i += 2) {
        const tmp = nums[i];
        nums[i] = nums[i + 1];
        nums[i + 1] = tmp;
    }
}
