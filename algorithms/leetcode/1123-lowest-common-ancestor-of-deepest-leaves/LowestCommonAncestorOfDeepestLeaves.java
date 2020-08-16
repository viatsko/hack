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
    int maxDepth = 0;
    TreeNode result = null;
    
    private int helper(TreeNode root, int depth) {
        maxDepth = Math.max(depth, maxDepth);
        
        if (root == null) {
            return depth;
        }
        
        int left = helper(root.left, depth + 1);
        int right = helper(root.right, depth + 1);
        
        if (left == maxDepth && right == maxDepth) {
            result = root;
        }
        
        return Math.max(left, right);
    }
    
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        helper(root, 0);
        return result;
    }
}
