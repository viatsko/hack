function isCryptSolution(crypt, solution) {
    const h = {};

    for (const e of solution) {
        h[e[0]] = e[1];
    }

    function sum(word) {
        let result = '';

        for (let i = 0; i < word.length; i++) {
            const r = h[word[i]];

            if (i === 0 && r === '0' && word.length !== 1) {
                return false;
            }

            result += r;
        }

        return ~~result;
    }

    const sumA = sum(crypt[0]);

    if (sumA === false) return false;

    const sumB = sum(crypt[1]);

    if (sumB === false) return false;

    const res = sum(crypt[2]);

    if (res === false) return false;

    return sumA + sumB === res;
}
