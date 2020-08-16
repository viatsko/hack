
const isPowerOfThree = n => {
    if (n < 1) {
        return false;
    }

    while (n % 3 === 0) {
        n = Math.floor(n / 3);
    }

    return n === 1;
}
