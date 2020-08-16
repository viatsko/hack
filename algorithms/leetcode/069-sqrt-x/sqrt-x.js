const mySqrt = num => {
    let n = num;

    while(n * n > num) {
        n = ((n + num / n) / 2) | 0;
    }

    return n;
};
