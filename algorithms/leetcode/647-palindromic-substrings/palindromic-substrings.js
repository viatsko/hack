const countSubstrings = s => {
    let count = 0;

    for (let i = 0; i < s.length; i++) {
        // cases like bab
        for (let j = 0; i - j >= 0 && j + i < s.length && s[i - j] === s[j + i]; j++) count++;
        // cases like baab
        for (let j = 0; i - 1 - j >= 0 && j + i < s.length && s[i - 1 - j] === s[j + i]; j++) count++;
    }

    return count;
};
