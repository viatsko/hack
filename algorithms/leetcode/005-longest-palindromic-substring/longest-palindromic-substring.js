const longestPalindrome = s => {
    let maxLen = 1;
    let maxStr = s[0];

    const findPalindrome = (begin, end, curLen) => {
        while(begin > -1 && end < s.length && s[begin] === s[end]) {
            curLen += 2;

            if (curLen > maxLen) {
                maxLen = curLen;
                maxStr = s.substring(begin, end + 1);
            }

            begin--;
            end++;
        }
    };

    for (let i = 0; i < s.length; i++) {
        findPalindrome(i - 1, i + 1, 1);
        findPalindrome(i, i + 1, 0);
    }

    return maxStr;
};
