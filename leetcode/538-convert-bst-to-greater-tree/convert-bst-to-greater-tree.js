const convertBST = root => {
    if (!root) {
        return null;
    }

    let sum = 0;

    const traverse = node => {
        if (!node) {
            return;
        }

        traverse(node.right);

        let tmp = node.val;
        node.val = sum + tmp;
        sum += tmp;

        traverse(node.left);
    };

    traverse(root);

    return root;
};
