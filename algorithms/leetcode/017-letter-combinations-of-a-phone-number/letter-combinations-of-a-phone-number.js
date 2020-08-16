const letterCombinations = digits => {
    if (digits.length === 0) {
        return [];
    }

    const c = new Map();
    c.set('*', ['+']);
    c.set('0', [' ']);
    c.set('1', []);
    c.set('2', ['a', 'b', 'c']);
    c.set('3', ['d', 'e', 'f']);
    c.set('4', ['g', 'h', 'i']);
    c.set('5', ['j', 'k', 'l']);
    c.set('6', ['m', 'n', 'o']);
    c.set('7', ['p', 'q', 'r', 's']);
    c.set('8', ['t', 'u', 'v']);
    c.set('9', ['w', 'x', 'y', 'z']);

    const d = digits.split('');
    const result = [];

    const combo = (s, d, idx) => {
        if (d.length === idx) {
            return result.push(s);
        }

        for (let i = 0; i < c.get(d[idx]).length; i++) {
            combo(s + c.get(d[idx])[i], d, idx + 1);
        }
    };

    combo('', d, 0);

    return result;
};
