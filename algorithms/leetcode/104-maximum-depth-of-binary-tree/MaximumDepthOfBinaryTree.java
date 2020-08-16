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
    private int maxDepth(TreeNode root, int level) {
        if (root == null) {
            return level;
        }
        
        return Math.max(maxDepth(root.left, level + 1), maxDepth(root.right, level + 1));
    }
    
    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }
}
