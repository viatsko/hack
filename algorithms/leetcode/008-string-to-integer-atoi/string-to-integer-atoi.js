const myAtoi = str => {
    const INT_MAX = 2147483647;
    const INT_MIN = -2147483648;

    let i = 0;
    let result = 0;
    let sign = 1;

    // skip spaces
    while(str[i] === ' ') {
        i++;
    }

    // spaces only - not valid integer
    if (!str[i]) {
        return 0;
    }

    if (str[i] === '+') { i++; }
    else if (str[i] === '-') {
        sign = -1;
        i++;
    }

    if (!str[i]) {
        return 0;
    }

    const nullcode = '0'.codePointAt(0);

    // picking first char
    let curchar = str[i].codePointAt(0) - nullcode;

    while(curchar >= 0 && curchar <= 9) {
        result = result * 10 + curchar;

        i++;

        if (!str[i]) {
            break;
        }

        curchar = str[i].codePointAt(0) - nullcode;
    }

    result = sign * result;

    if (result > INT_MAX) {
        return INT_MAX
    } else if (result < INT_MIN) {
        return INT_MIN;
    } else {
        return result;
    }
};
