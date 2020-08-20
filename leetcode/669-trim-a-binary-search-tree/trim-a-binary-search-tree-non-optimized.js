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

const trimBST = (root, L, R) => {
    if (!root) {
        return root;
    }

    while (root && (root.val < L || root.val > R)) {
        root = deleteNode(root, root.val);
    }

    if (root) {
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
    }

    return root;
};
