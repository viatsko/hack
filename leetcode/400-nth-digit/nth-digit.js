const findNthDigit = n => {
    n -= 1;

    let base = 1;
    let digits = 1;
    while(true) {
        const begin = base;

        if (n < 9 * begin * digits) {
            return Number(String(begin + Math.floor(n / digits))[n % digits]);
        }

        n -= 9 * begin * digits;

        digits++;
        base *= 10;
    }
};
