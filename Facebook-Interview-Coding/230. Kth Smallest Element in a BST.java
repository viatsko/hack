230. Kth Smallest Element in a BST



private int res = 0, count;
public int kthSmallest(TreeNode root, int k) {
    //recursive
    count = k;
    dfsInOrder(root);
    return res;
}
public void dfsInOrder(TreeNode root) {
    if (root.left != null)  dfsInOrder(root.left);
    count--;
    if (count == 0) {
        res = root.val;
        return;
    }
    if (root.right != null) dfsInOrder(root.right);
}



//iterative
public int kthSmallest(TreeNode root, int k) {
    Stack<TreeNode> stack = new Stack<>();
    while (root != null) {
        stack.push(root);
        root = root.left;
    }
    while (k > 0) {
        TreeNode tmp = stack.pop();
        if (--k == 0)   return tmp.val;
        tmp = tmp.right;
        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.left;
        }
    }
    return -1;
}