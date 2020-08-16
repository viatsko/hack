const maxDepth = root => {
    return !root ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
};
