
const findAnagrams = (s, p) => {
    const ps = [];
    const ss = [];

    const result = [];

    const eqSets = (a, b) => {
        return !Object.keys(a).filter((key) => a[key] !== b[key]).length;
    }

    for (let i = 0; i < p.length; i++) {
        ps[p[i]] = -~ps[p[i]];
        ss[s[i]] = -~ss[s[i]]
    }

    if (eqSets(ps, ss)) {
        result.push(0);
    }

    for (let i = p.length; i < s.length; i++) {
        ss[s[i - p.length]] = ~(-ss[s[i - p.length]]);
        ss[s[i]] = -~ss[s[i]]

        if (eqSets(ps, ss)) {
            result.push(i - p.length + 1);
        }
    }

    return result;
}
