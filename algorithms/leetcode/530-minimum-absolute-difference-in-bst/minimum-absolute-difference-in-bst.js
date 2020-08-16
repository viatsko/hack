const getMinimumDifference = root => {
    if (!root) {
        return null;
    }

    let min = Number.POSITIVE_INFINITY;
    let prev;

    const traverse = node => {
        if (!node) {
            return;
        }

        traverse(node.left);

        if (prev !== undefined) {
            min = Math.min(node.val - prev, min);
        }

        prev = node.val;

        traverse(node.right);
    };

    traverse(root);

    return min;
};
