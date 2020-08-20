const findTilt = root => {
    let total = 0;

    const traverse = (node, sum) => {
        if (!node) {
            return 0;
        }

        const left = traverse(node.left, sum);
        const right = traverse(node.right, sum);

        total += Math.abs(left - right);

        return left + right + node.val;
    };

    traverse(root, 0);

    return total;
};
