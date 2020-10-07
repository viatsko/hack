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
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }

    Queue<TreeNode> q1 = new LinkedList<>();
    q1.offer(p);

    Queue<TreeNode> q2 = new LinkedList<>();
    q2.offer(q);

    while (!q1.isEmpty() && !q2.isEmpty()) {
      TreeNode n1 = q1.poll();
      TreeNode n2 = q2.poll();

      if (n1 == null && n2 == null) {
        continue;
      } else if (n1 == null || n2 == null) {
        return false;
      } else if (n1.val != n2.val) {
        return false;
      }

      q1.offer(n1.left);
      q1.offer(n1.right);
      q2.offer(n2.left);
      q2.offer(n2.right);
    }

    if (!q1.isEmpty() || !q2.isEmpty()) {
      return false;
    }

    return true;
  }
}
