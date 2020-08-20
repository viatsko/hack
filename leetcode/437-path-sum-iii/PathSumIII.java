public class PathSumIII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int downSum(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }

        return (node.val == sum ? 1 : 0) + downSum(node.left, sum - node.val) + downSum(node.right, sum - node.val);
    }

    public int pathSum(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }

        return downSum(node, sum) + pathSum(node.left, sum) + pathSum(node.right, sum);
    }
}
