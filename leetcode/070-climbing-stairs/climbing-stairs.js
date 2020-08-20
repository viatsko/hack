const memo = {};

const climbStairs = n => {
    if (n <= 2) {
        return n;
    }

    if (memo[n]) {
        return memo[n];
    }

    const result = climbStairs(n - 2) + climbStairs (n - 1);

    memo[n] = result;

    return result;
};
