const deleteNode = (root, key) => {
    if (!root) {
        return root;
    }

    if (key < root.val) {
        root.left = deleteNode(root.left, key);
    } else if (key > root.val) {
        root.right = deleteNode(root.right, key);
    } else {
        if (root.left && root.right) {
            let minNode = root.right;

            while (minNode.left) minNode = minNode.left;

            root.val = minNode.val;
            root.right = deleteNode(root.right, root.val);
        } else if (root.left) {
            root = deleteNode(root.left, key);
        } else if (root.right) {
            root = deleteNode(root.right, key);
        } else {
            root = null;
        }
    }

    return root;
};
