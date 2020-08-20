const inorderTraversal = root => {
    const result = [];

    const st = [];

    let node = root;

    while(node !== null || st.length) {
        while(node) {
            st.push(node);
            node = node.left;
        }

        node = st.pop();

        result.push(node.val);

        node = node.right;
    }

    return result;
};
