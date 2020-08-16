const isBalanced = root => {
    if (!root) {
        true;
    }

    const getHeight = node => {
        if (!node) {
            return 0;
        }

        const left = getHeight(node.left);
        const right = getHeight(node.right);

        if (left === false || right === false || Math.abs(left - right) > 1) {
            return false;
        }

        return 1 + Math.max(left, right);
    };

    return getHeight(root) !== false;
};
