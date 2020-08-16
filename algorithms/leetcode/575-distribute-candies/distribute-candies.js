const distributeCandies = candies => {
    const half = candies.length >> 1;

    const sisterCandies = new Set();

    for (const candy of candies) {
        sisterCandies.add(candy);

        if (sisterCandies.size === half) {
            break;
        }
    }

    return sisterCandies.size;
};
