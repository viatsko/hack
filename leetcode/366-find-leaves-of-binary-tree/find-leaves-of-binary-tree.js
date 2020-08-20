const findLeaves = root => {
    const result = [];

    const isLeaf = node => !node.left && !node.right;

    let row;
    const traverse = node => {
        if (!node) {
            return null;
        }

        if (isLeaf(node)) {
            row.push(node.val);
            return null;
        }

        node.left = traverse(node.left);
        node.right = traverse(node.right);

        return node;
    };

    while (root !== null) {
        row = [];
        root = traverse(root);
        result.push(row);
    }

    return result;
};
