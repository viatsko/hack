const isPowerOfFour = num => {
    // 0x55555555 is a result of XOR 1, 100, 10000, 1000000 etc
    return (num > 0) && ((num & (num - 1)) === 0) && ((num & 0x55555555) === num);
};
