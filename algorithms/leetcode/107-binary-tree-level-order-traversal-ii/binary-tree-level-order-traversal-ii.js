const levelOrderBottom = root => {
    const levels = [];

    const traverse = (node, level) => {
        if (!node) {
            return;
        }

        if (!levels[level]) {
            levels[level] = [node.val];
        } else {
            levels[level].push(node.val);
        }

        traverse(node.left, level + 1);
        traverse(node.right, level + 1);
    };

    traverse(root, 0);

    return levels.reverse();
};
