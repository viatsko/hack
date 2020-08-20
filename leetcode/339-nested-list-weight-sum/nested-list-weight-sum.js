const depthSum = nestedList => {
    let result = 0;

    const walk = (nestedList, depth) => {
        for (const nestedInteger of nestedList) {
            if (nestedInteger.isInteger()) {
                result += nestedInteger.getInteger() * depth;
            } else {
                walk(nestedInteger.getList(), depth + 1);
            }
        }
    };

    walk(nestedList, 1);

    return result;
};
