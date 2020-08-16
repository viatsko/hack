const isValidBST = root => {
    const validate = (node, min, max) => {
        if (!node) {
            return true;
        }

        if (
            (node.val > min && node.val < max) &&
            ((node.left === null) || (node.left.val < node.val)) &&
            ((node.right === null) || (node.right.val > node.val))
        ) {
            return validate(node.left, min, node.val) && validate(node.right, node.val, max);
        } else {
            return false;
        }
    };

    return validate(root, Number.NEGATIVE_INFINITY, Number.POSITIVE_INFINITY);
};
