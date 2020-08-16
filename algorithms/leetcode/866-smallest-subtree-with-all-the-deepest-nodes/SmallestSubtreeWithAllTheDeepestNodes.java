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
  private int maxDepth;
  private TreeNode leftMost;
  private TreeNode rightMost;

  private void findDepth(TreeNode node, int depth) {
    if (node == null) {
      return;
    }

    if (node.left == null && node.right == null) {
      if (depth == maxDepth) {
        rightMost = node;
      } else if (depth > maxDepth) {
        maxDepth = depth;
        leftMost = node;
        rightMost = node;
      }
    }

    findDepth(node.left, depth + 1);
    findDepth(node.right, depth + 1);
  }

  public TreeNode traverse(TreeNode node) {
    if (node == null) {
      return null;
    }

    if (node == leftMost || node == rightMost) {
      return node;
    }

    TreeNode left = traverse(node.left);
    TreeNode right = traverse(node.right);

    if (left != null && right != null) {
      return node;
    }

    if (left == null && right == null) {
      return null;
    }

    if (left == null) {
      return right;
    } else {
      return left;
    }
  }

  public TreeNode subtreeWithAllDeepest(TreeNode root) {
    maxDepth = 0;
    leftMost = null;
    rightMost = null;

    findDepth(root, 0);

    return traverse(root);
  }
}
