const postorderTraversal = root => {
    const result = [];
    const st = [];
    let node = root;

    while(node || st.length) {
        if (node) {
            st.push(node);

            result.unshift(node.val);

            node = node.right;
        } else {
            node = st.pop().left;
        }
    }

    return result;
};
