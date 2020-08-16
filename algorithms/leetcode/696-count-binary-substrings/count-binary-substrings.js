const countBinarySubstrings = s => {
    let count = 0;

    for (let i = 0; i < s.length; i++) {
        let curLen = 1;
        const curChar = s[i];
        const invChar = curChar === '0' ? '1' : '0';

        let j = i;
        while(s[j + 1] === curChar) {
            curLen++;
            j++;
        }

        while(curLen > 0 && s[j + 1] === invChar) {
            curLen--;
            j++;
        }

        if (!curLen) {
            count++;
        }
    }

    return count;
};
