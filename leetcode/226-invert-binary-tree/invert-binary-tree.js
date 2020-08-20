
const invertTree = (root) => {
    if (!root) {
        return null;
    }

    const t = invertTree(root.left);
    root.left = invertTree(root.right);
    root.right = t;

    return root;
};
