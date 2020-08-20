const generateParenthesis = n => {
    const result = [];

    const generate = (str, left, right) => {
        if (str.length === n * 2) {
            return result.push(str);
        }

        if (left < n) {
            generate(str + '(', left + 1, right);
        }

        if (right < left) {
            generate(str + ')', left, right + 1);
        }
    };

    generate('', 0, 0);

    return result;
};
