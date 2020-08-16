const isNumber = function(s) {
    s = s.trim();

    const char0 = '0'.codePointAt(0);
    const char9 = '9'.codePointAt(0);

    let isNumber = false;
    let isNumberAfterE = false;
    let hasPoint = false;
    let hasE = false;

    for (let i = 0; i < s.length; i++) {
        const c = s[i].codePointAt(0);

        if (c >= char0 && c <= char9) {
            isNumber = true;
            isNumberAfterE = true;
        } else if (s[i] === '.') {
            if (hasPoint || hasE) {
                return false;
            }

            hasPoint = true;
        } else if (s[i] === 'e') {
            if (hasE || !isNumber) {
                return false;
            }

            hasE = true;
            isNumberAfterE = false;
        } else if (s[i] === '+' || s[i] === '-') {
            if (i !== 0 && s[i - 1] !== 'e') {
                return false;
            }
        } else {
            return false;
        }
    }

    return isNumber && isNumberAfterE;
};
