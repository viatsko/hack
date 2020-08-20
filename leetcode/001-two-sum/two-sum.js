const twoSum = (n, t) => {
    const h = {};

    for (let i = 0; i < n.length; i++) {
        const val = n[i];

        if (Object.prototype.hasOwnProperty.call(h, t - val)) {
            return [h[t - val], i];
        } else {
            h[val] = i;
        }
    }
};
