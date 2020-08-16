const maxCount = (m, n, ops) => {
    let minX = Number.MAX_SAFE_INTEGER;
    let minY = Number.MAX_SAFE_INTEGER;

    let num = 0;

    for (let i = 0; i < ops.length; i++) {
        minX = Math.min(ops[i][0], minX);
        minY = Math.min(ops[i][1], minY);
        num++;
    }

    return !ops.length ? (m * n) : (minX * minY);
};
