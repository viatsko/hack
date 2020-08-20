const romanToInt = s => {
    const rome = new Map();
    rome.set('M', 1000);
    rome.set('D', 500);
    rome.set('C', 100);
    rome.set('L', 50);
    rome.set('X', 10);
    rome.set('V', 5);
    rome.set('I', 1);

    let result = 0;

    for (let i = 0; i < s.length - 1; i++) {
        const cur = rome.get(s[i]);
        const next = rome.get(s[i + 1]);

        if (next && next > cur) {
            result -= cur;
        } else {
            result += cur;
        }
    }

    return result + rome.get(s[s.length - 1]);
};
