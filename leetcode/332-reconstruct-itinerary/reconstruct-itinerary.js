const findItinerary = tickets => {
    tickets.sort((a, b) => {
        return a[0] === b[0] ? a[1].localeCompare(b[1]) : a[0].localeCompare(b[0]);
    });

    const dests = {};

    for (const ticket of tickets) {
        const from = ticket[0];
        const to = ticket[1];

        if (!dests.hasOwnProperty(from)) {
            dests[from] = [];
        }

        dests[from].push(to);
    }

    const result = ['JFK'];

    const helper = (dest, count) => {
        if (count >= tickets.length) {
            return true; // end of recursion, result is ready
        }

        if (!dests[dest] || !dests[dest].length) {
            return;
        }

        const l = dests[dest].length;

        for (let i = 0; i < l; i++) {
            const tmp = dests[dest].shift();

            result.push(tmp);

            if (helper(tmp, count + 1) === true) {
                return true;
            }

            result.pop();

            dests[dest].push(tmp);
        }
    };

    helper(result[0], 0);

    return result;
};
