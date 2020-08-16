public class SymmetricTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean helper(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            // check if one of these is not null
            return left == right;
        }

        if (left.val != right.val) {
            return false;
        }

        return helper(left.left, right.right) && helper(left.right, right.left);
    }

    public boolean isSymmetric(TreeNode root) {
        return root == null || helper(root.left, root.right);
    }
}
