
const rightSideView = root => {
    let node = root;

    const result = [];

    const rightSide = (node, curLen) => {
        if (!node) {
            return;
        }

        if (curLen === result.length) {
            result.push(node.val);
        }

        rightSide(node.right, curLen + 1);
        rightSide(node.left, curLen + 1);
    }

    rightSide(node, 0);

    return result;
}
