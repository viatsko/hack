const minDepth = root => {
    if (!root) {
        return 0;
    }

    const traverse = (node, level) => {
        if (!node.left && !node.right) {
            return level;
        }

        return Math.min(node.left ? traverse(node.left, level + 1) : Number.POSITIVE_INFINITY, node.right ? traverse(node.right, level + 1) : Number.POSITIVE_INFINITY)
    };

    return traverse(root, 1)
};
