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
    private boolean checkSubtree(TreeNode root, TreeNode t) {
        if (root == null && t == null) {
            return true;
        }
        
        if (root == null || t == null) {
            return false;
        }
        
        if (root.val == t.val) {
            return checkSubtree(root.left, t.left) && checkSubtree(root.right, t.right);
        }
        
        return false;
    }
    
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        
        return checkSubtree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }
}
