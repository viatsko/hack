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
    int max = Integer.MIN_VALUE;
    
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        // Math.max is to drop a branch if it's 0
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        
        max = Math.max(max, left + right + root.val);
        
        return Math.max(left, right) + root.val;
    }
    
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        helper(root);
        
        return max;
    }
}
