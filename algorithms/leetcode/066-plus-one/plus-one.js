const plusOne = digits => {
    let leftover = 1;

    for (let i = digits.length - 1; i >= 0; i--) {
        let sum = digits[i] + leftover;

        if (sum === 10) {
            digits[i] = 0;
            leftover = 1;
        } else {
            digits[i] = sum;
            leftover = 0;
        }
    }

    if (leftover > 0) {
        digits.unshift(leftover);
    }

    return digits;
};
