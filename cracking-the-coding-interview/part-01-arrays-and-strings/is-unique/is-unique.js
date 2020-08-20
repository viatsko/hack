const isUnique = str => {
    const charBase = 'a'.charCodeAt(0) - 1;

    let store = 0;

    for (const c of str) {
        const ch = c.charCodeAt(0) - charBase;

        if (store & (1 << ch)) {
            return false;
        }

        store |= (1 << ch);
    }

    return true;
};

console.log(isUnique('abba') === false);
console.log(isUnique('abcd') === true);
