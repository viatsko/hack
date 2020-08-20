const selfDividingNumbers = function(left, right) {
    const result = [];

    for (let i = left; i <= right; i++) {
        const num = i.toString();

        let valid = true;

        for (const digit of num.split('')) {
            if (num % parseInt(digit) !== 0) {
                valid = false;
                break;
            }
        }

        if (valid) {
            result.push(parseInt(num));
        }
    }

    return result;
};
