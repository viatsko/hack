const findSecondMinimumValue = root => {
    const traverse = node => {
        if (!node) {
            return Number.POSITIVE_INFINITY;
        }

        if (node.val !== root.val) {
            return node.val;
        }

        return Math.min(traverse(node.left), traverse(node.right));
    };

    const result = traverse(root);

    return result === Number.POSITIVE_INFINITY ? -1 : result;
};
