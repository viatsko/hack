public class DiameterOfBinaryTree {
    public class TreeNode {
        int val;

        TreeNode left;

        TreeNode right;

        TreeNode (int x) {
            val = x;
        }
    }

    int result = 0;

    private int traverse(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = traverse(node.left);
        int right = traverse(node.right);

        result = Math.max(result, left + right);

        return Math.max(left, right) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        traverse(root);

        return result;
    }
}
