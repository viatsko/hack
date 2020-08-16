const addStrings = (num1, num2) => {
    let leftover = 0;
    const result = [];

    num1 = num1.split('');
    num2 = num2.split('');

    while(num1.length || num2.length) {
        let sum = Number(num1.length ? num1.pop() : 0) + Number(num2.length ? num2.pop() : 0) + leftover;

        if (sum >= 10) {
            leftover = Math.floor(sum / 10);
            sum = sum % 10;
        } else {
            leftover = 0;
        }

        result.unshift(sum);
    }

    if (leftover) {
        result.unshift(leftover);
    }

    return result.join('');
};
