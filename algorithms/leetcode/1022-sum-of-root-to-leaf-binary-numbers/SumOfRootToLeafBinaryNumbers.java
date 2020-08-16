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
    int result = 0;
    
    private void helper(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        
        sum <<= 1;
        sum += root.val;
        
        if (root.left == null && root.right == null) {
            result += sum;
        } else {
            helper(root.left, sum);
            helper(root.right, sum);
        }
    }
    
    public int sumRootToLeaf(TreeNode root) {
        helper(root, 0);
        
        return result;
    }
}
