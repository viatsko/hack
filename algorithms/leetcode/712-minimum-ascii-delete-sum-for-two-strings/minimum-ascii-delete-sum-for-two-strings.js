const minimumDeleteSum = (s1, s2) => {
    const dp = [];

    for (let i = 0; i <= s1.length; i++) {
        dp[i] = [0];
    }

    for (let i = 0; i <= s2.length; i++) {
        dp[0][i] = 0;
    }

    for (let i = 1; i <= s1.length; i++) {
        for (let j = 1; j <= s2.length; j++) {
            if (s1[i - 1] === s2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + s1[i - 1].charCodeAt(0);
            } else {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
    }

    let ascii1 = 0;

    for (let i = 0; i < s1.length; i++) {
        ascii1 += s1[i].charCodeAt(0);
    }

    let ascii2 = 0;

    for (let i = 0; i < s2.length; i++) {
        ascii2 += s2[i].charCodeAt(0);
    }

    return ascii1 + ascii2 - 2 * dp[s1.length][s2.length];
};
