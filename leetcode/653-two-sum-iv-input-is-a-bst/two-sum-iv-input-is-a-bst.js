const findTarget = (root, k) => {
    const set = new Set();

    const dfs = node => {
        if (!node) {
            return false;
        }

        if (set.has(k - node.val)) {
            return true;
        }

        set.add(node.val);

        return dfs(node.left) || dfs(node.right);
    };

    return dfs(root);
};
