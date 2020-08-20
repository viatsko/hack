const findTheDifference = (s, t) => {
    const letters = {};

    for (let i = 0; i < s.length; i++) {
        letters[s[i]] = -~letters[s[i]];
    }

    for (let i = 0; i < t.length; i++) {
        if (!letters[t[i]]) {
            return t[i];
        }

        letters[t[i]]--;
    }

    return '';
};
