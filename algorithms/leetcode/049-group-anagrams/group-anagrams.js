const groupAnagrams = strs => {
    const h = {};

    for (const str of strs) {
        const sorted = [...str].sort((a, b) => a.localeCompare(b));

        if (!h[sorted]) {
            h[sorted] = [];
        }

        h[sorted].push(str);
    }

    const result = [];
    for (const arr in h) {
        result.push(h[arr].sort((a, b) => a.localeCompare(b)));
    }

    return result;
};
