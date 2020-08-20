const largestValues = root => {
    const rows = [];

    const traverse = (node, level) => {
        if (!node) {
            return;
        }

        if (!rows[level])
            rows[level] = [node.val];
        else
            rows[level][rows[level].length] = node.val;

        traverse(node.left, level + 1);
        traverse(node.right, level + 1);
    };

    traverse(root, 0);

    return rows.map(level => Math.max.call(Math, ...level));
};
