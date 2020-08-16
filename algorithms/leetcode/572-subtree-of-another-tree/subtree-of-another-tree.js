const isSubtree = (s, t) => {
    const checkSubTree = (root, root2) => {
        if (!root && !root2) {
            return true;
        }

        if (!root || !root2) {
            return false;
        }

        if (root.val !== root2.val) {
            return false;
        }

        return checkSubTree(root.left, root2.left) && checkSubTree(root.right, root2.right);
    };

    const traverse = node => {
        if (!node) {
            return false;
        }

        if (node.val === t.val) {
            if (checkSubTree(node, t)) {
                return true;
            }
        }

        return traverse(node.left) || traverse(node.right);
    };

    return traverse(s);
};
