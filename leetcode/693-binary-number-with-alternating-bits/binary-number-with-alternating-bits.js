const hasAlternatingBits = n => {
    let prev = -1;

    while(n !== 0) {
        const cur = n & 1;
        if (prev === cur) {
            return false;
        }

        prev = cur;
        n >>= 1;
    }

    return true;
};
