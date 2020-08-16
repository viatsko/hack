const findPermutation = s => {
    const result = new Array(s.length + 1);

    for (let i = 0, cur = 1; i < result.length; i++) {
        if (s[i] === 'D') {
            let j = i;

            while(s[j] === 'D') {
                j++;
            }

            for (let k = j; k >= i; k--) {
                result[k] = cur++;
            }

            i = j;
        } else {
            result[i] = cur++;
        }
    }

    return result;
};
