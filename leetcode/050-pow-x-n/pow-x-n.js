const myPow = (x, n) => {
    if (n === 0) {
        return 1;
    }

    if (n < 0) {
        n = -n;
        x = 1/x;
    }

    return (n & 1) ? myPow(x, n - 1) * x : myPow(x*x, n / 2);
};
