const preorderTraversal = root => {
    const result = [];

    if (!root) {
        return result;
    }

    const st = [root];

    while(st.length) {
        let node = st.pop();

        result.push(node.val);

        if (node.right) {
            st.push(node.right);
        }

        if (node.left) {
            st.push(node.left);
        }
    }

    return result;
};
