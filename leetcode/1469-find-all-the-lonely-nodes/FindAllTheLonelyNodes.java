/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  public List<Integer> getLonelyNodes(TreeNode root) {
    List<Integer> result = new LinkedList<>();
    helper(root, false, result);
    return result;
  }

  private void helper(TreeNode node, boolean candidate, List<Integer> result) {
    if (node == null) {
      return;
    }

    if (candidate) {
      result.add(node.val);
    }

    helper(node.left, node.left == null || node.right == null, result);
    helper(node.right, node.left == null || node.right == null, result);
  }
}
