/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  private int traverse(TreeNode node, boolean isLeft) {
    if(node.left == null && node.right == null) {
      return isLeft ? node.val : 0;
    }

    return (node.left == null ? 0 : traverse(node.left, true)) + (node.right == null ? 0 : traverse(node.right, false));
  }

  public int sumOfLeftLeaves(TreeNode root) {
    if (root == null) {
      return 0;
    }

    return traverse(root, false);
  }
}
