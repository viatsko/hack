const levelOrder = root => {
    const result = [];

    let node = root;

    const scanLevel = (node, level) => {
        if (!node) {
            return;
        }

        if (!result[level]) {
            result[level] = [];
        }

        result[level].push(node.val);

        scanLevel(node.left, level + 1);
        scanLevel(node.right, level + 1);
    };

    scanLevel(node, 0);

    return result;
};
