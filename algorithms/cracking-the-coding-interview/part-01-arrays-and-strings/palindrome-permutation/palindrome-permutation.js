const palindromePermutation = str => {
    str = str.toLowerCase();

    const CHAR_A = 'a'.charCodeAt(0);
    const CHAR_Z = 'z'.charCodeAt(0);

    const set = new Set();

    for (const c of str) {
        const ch = c.charCodeAt(0);

        if (!(ch >= CHAR_A && ch <= CHAR_Z)) {
            continue;
        }

        if (set.has(c)) {
            set.delete(c);
        } else {
            set.add(c);
        }
    }

    return set.size <= 1;
};

console.log(palindromePermutation('Tact Coa'));
