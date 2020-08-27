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
  public void helper(TreeNode root, List<List<Integer>> levels, int level) {
    if (root == null) {
      return;
    }

    if (levels.size() < level + 1) {
      levels.add(new ArrayList<>());
    }

    levels.get(level).add(root.val);

    helper(root.left, levels, level + 1);
    helper(root.right, levels, level + 1);
  }

  public int deepestLeavesSum(TreeNode root) {
    List<List<Integer>> levels = new ArrayList<>();

    helper(root, levels, 0);

    if (levels.size() == 0) {
      return 0;
    }

    return levels.get(levels.size() - 1).stream().reduce(0, Integer::sum);
  }
}
