const findBottomLeftValue = root => {
    let maxLevel = -1;
    let value = -1;

    const dfs = (node, level) => {
        if (!node) {
            return null;
        }

        if (level > maxLevel) {
            maxLevel = level;
            value = node.val;
        }

        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    };

    dfs(root, 0);

    return value;
};
