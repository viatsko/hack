
const detectCapitalUse = word => {
    const A = 'A'.codePointAt(0);

    const Z = 'Z'.codePointAt(0);

    const isCapital = c => {
        return c.codePointAt(0) >= A && c.codePointAt(0) <= Z;
    }

    let noncapitals = 0;
    let capitals = 0;

    for (let i = 0; i < word.length; i++) {
        if (capitals > 1 && !isCapital(word[i])) {
            return false;
        }

        if (isCapital(word[i])) {
            if (!noncapitals) {
                capitals++;
            } else {
                return false;
            }
        } else {
            noncapitals++;
        }
    }

    return true;
}
