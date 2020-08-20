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
    int current = 0;
    int result = Integer.MIN_VALUE;
    
    private void helper(TreeNode root, int k) {
        if (root == null || current >= k) {
            return;
        }
        
        helper(root.left, k);
        
        current++;
        
        if (current == k) {
            result = root.val;
            return;
        }
        
        helper(root.right, k);
    }
    
    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return result;
    }
}
