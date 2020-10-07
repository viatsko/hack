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
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();

    if (root == null) {
      return result;
    }

    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);

    boolean isReversed = true;

    while (!q.isEmpty()) {
      List<Integer> subResult = new ArrayList<>();

      int size = q.size();
      for (int i = 0; i < size; i++) {
        TreeNode curr = q.poll();
        subResult.add(curr.val);

        if (curr.left != null) q.offer(curr.left);
        if (curr.right != null) q.offer(curr.right);
      }

      if (!isReversed)
        Collections.reverse(subResult);

      isReversed = !isReversed;

      result.add(subResult);
    }

    return result;
  }
}
