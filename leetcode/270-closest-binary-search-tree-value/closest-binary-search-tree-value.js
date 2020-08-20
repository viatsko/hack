const closestValue = (root, target) => {
    let result = root.val;

    let node = root;
    while (node !== null) {
        if (Math.abs(target - node.val) < Math.abs(target - result)) {
            result = node.val;
        }

        node = node.val > target ? node.left : node.right;
    }

    return result;
};
