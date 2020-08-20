const hasPathSum = (root, sum) => {
    const traverse = (root, currentSum) => {
        if (!root) {
            return false;
        }

        currentSum += root.val;

        if (currentSum === sum && !root.left && !root.right) {
            return true;
        }

        return traverse(root.left, currentSum) || traverse(root.right, currentSum);
    };

    return traverse(root, 0);
};
