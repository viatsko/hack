function TreeNode(val) {
    this.val = val;
    this.left = this.right = null;
}

const inorderSuccessor = (root, p) => {
    if (!root) {
        return null;
    }

    if (p.val >= root.val) {
        return inorderSuccessor(root.right, p);
    } else {
        const left = inorderSuccessor(root.left, p);
        return left === null ? root : left;
    }
};

const root = new TreeNode(7);
const node5 = root.left = new TreeNode(5);
const node12 = root.right = new TreeNode(12);
const node9 = node12.left = new TreeNode(9);
const node15 = node12.right = new TreeNode(15);
const node8 = node9.left = new TreeNode(8);
const node10 = node9.right = new TreeNode(10);

console.log(inorderSuccessor(root, node9));
