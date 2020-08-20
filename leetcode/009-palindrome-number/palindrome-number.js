const isPalindrome = x => {
    if (x < 0) {
        return false;
    }

    let max10 = Math.floor(Math.log10(x));
    let div = Math.pow(10, max10);

    while (x > 0) {
        let a = Math.floor(x / div);
        let b = x % 10;

        if (a !== b) {
            return false;
        }

        x = Math.floor((x % div) / 10);
        div = div / 100;
    }

    return true;
};
