
const sumOfLeftLeaves = root => {
    let sum = 0;

    const walk = node => {
        if (!node) {
            return;
        }

        if (node.left && !node.left.left && !node.left.right) {
            sum += node.left.val;
        }

        walk(node.left);
        walk(node.right);
    };

    walk(root);

    return sum;
}
