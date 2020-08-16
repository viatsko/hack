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
  Queue<Integer> leaves;

  private void fill(TreeNode node) {
      if (node == null) {
          return;
      }

      if (node.left == null && node.right == null) {
          leaves.offer(node.val);
      }

      fill(node.left);
      fill(node.right);
  }

  private boolean check(TreeNode node) {
      if (node == null) {
          return true;
      }

      if (node.left == null && node.right == null) {
          return leaves.size() > 0 && leaves.poll().equals(node.val);
      }

      return check(node.left) && check(node.right);
  }

  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
      leaves = new LinkedList<>();

      fill(root1);

      return check(root2) && leaves.size() == 0;
  }
}
