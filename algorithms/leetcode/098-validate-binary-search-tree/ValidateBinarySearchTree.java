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
    private boolean isValidBST(TreeNode root, Integer lowerLimit, Integer upperLimit) {
        if (root == null) {
            return true;
        }
        
        if (lowerLimit != null && root.val <= lowerLimit || upperLimit != null && root.val >= upperLimit) {
            return false;
        }
        
        return isValidBST(root.left, lowerLimit, root.val) && isValidBST(root.right, root.val, upperLimit);
    }
    
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }
}
