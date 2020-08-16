const reverse = x => {
    const maxInteger = 2**31;
    const sign = x < 0 ? (-1) : 1;

    x = Math.abs(x);

    let div = Math.pow(10, Math.floor(Math.log10(x)));
    let mult = 1;

    let result = 0;

    while (x > 0) {
        result += Math.floor(x / div) * mult;

        x = x % div;
        div = div / 10;
        mult = mult * 10;
    }

    return ((sign < 0) ? (result > maxInteger) : (result > (maxInteger - 1))) ? 0 : result * sign;
};
