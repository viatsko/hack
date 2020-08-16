
const kthSmallest = (root, k) => {
    let current = root;
    
    const st = [];
    
    while (current || st.length !== 0) {
        /*
         * Walking left until we can as the one
         * which is far left is the minimum one
         */
        if (current) {
            st.push(current);
            
            current = current.left;
        /*
         * Now checking siblings for every left node
         * and decrementing k
         */
        } else {
            current = st.pop();
            
            k--;
            
            if (k === 0) {
                return current.val;
            }
            
            current = current.right;
        }
    }
}
