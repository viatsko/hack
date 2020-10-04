173. Binary Search Tree Iterator

public class BSTIterator {
    private Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushAll(root);
    }
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    public int next() {
        TreeNode node = stack.pop();
        pushAll(node.right);
        return node.val;
    }   
    private void pushAll(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
******变种******
写个BST的in-order iterator，要写的function有 next() 和 all(), all() return所有剩下的。
public class BSTIterator {
    private Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushAll(root);
    }
    private void pushAll(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    public TreeNode next() {
        TreeNode node = stack.pop();
        pushAll(node.right);
        return node;
    }   
    public List<TreeNode> all() {
        List<TreeNode> res = new ArrayList<>();
        while (hasNext()) 
            res.add(next());
        return res;
    }
}

************Follow up******
改成 preorder 和 postorder。 我全用的stack

public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null)   return res; // corner check
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.empty()) {
        res.add(stack.pop().val);
        if (root.right != null)     stack.push(root.right);
        if (root.left != null)      stack.push(root.left);
    }
    return res;
}

public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    while (root != null || !stack.empty()) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        res.add(stack.pop().val);
        root = root.right;
    }
    return res;
}

public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode prev = null;
    while (root != null || !stack.empty()) {
        if (root != null) {
            stack.push(root);
            root = root.left;
        } else {
            TreeNode tmp = stack.peek();
            if (tmp.right != null && tmp.right != prev)
                root = tmp.right;
            else {
                stack.pop();
                res.add(tmp.val);
                prev = tmp;
            }
        }
    }
    return res;
}