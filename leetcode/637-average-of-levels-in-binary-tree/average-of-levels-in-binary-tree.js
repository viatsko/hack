const averageOfLevels = root => {
    const sums = [];
    const counts = [];

    const traverse = (node, depth) => {
        if (!node) {
            return;
        }

        if (!sums[depth])
            sums[depth] = node.val;
        else
            sums[depth] += node.val;

        counts[depth] = -~counts[depth];

        traverse(node.left, depth + 1);
        traverse(node.right, depth + 1)
    };

    traverse(root, 0);

    return sums.map((sum, index) => sum / counts[index]);
};
