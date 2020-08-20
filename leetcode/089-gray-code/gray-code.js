const grayCode = n => {
    const result = [];

    for (let i = 0; i < 1 << n; i++) {
        result.push(i ^ i >> 1);
    }

    return result;
};
