const combinationSum = (candidates, target) => {
    const result = [];

    const f = (left, combs, i) => {
        for (; i < candidates.length; i++) {
            if (candidates[i] > left) {
                continue;
            }

            combs.push(candidates[i]);

            if (candidates[i] === left) {
                result.push(combs.slice(0));
            } else {
                f(left - candidates[i], combs, i);
            }

            combs.pop();
        }
    };

    f(target, [], 0);

    return result;
};
