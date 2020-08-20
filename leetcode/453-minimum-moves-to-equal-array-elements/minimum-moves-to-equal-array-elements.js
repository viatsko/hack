const minMoves = nums => {
    return nums.reduce((a, b) => a + b) - nums.length * Math.min.call(Math, ...nums);
};
