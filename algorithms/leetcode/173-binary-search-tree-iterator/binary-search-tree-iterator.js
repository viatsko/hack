
class BSTIterator {
    /**
     * @constructor
     * @param {TreeNode} root - root of the binary search tree
     */
    constructor(root) {
        this.st = [];
        this.move(root);
    }

    move(node) {
        for(; node; node = node.left) {
            this.st.push(node);
        }
    }


    /**
     * @this BSTIterator
     * @returns {boolean} - whether we have a next smallest number
     */
    hasNext() {
        return this.st.length;
    }

    /**
     * @this BSTIterator
     * @returns {number} - the next smallest number
     */
    next() {
        const node = this.st.pop();
        this.move(node.right);
        return node.val;
    }
}
