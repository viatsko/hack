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
    int preorderIndex = 0;
    
    private TreeNode helper(int[] preorder, int[] inorder, int inorderLb, int inorderUb) {
        if (inorderUb - inorderLb <= 0) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[preorderIndex++]);
        
        for (int i = inorderLb; i < inorderUb; i++) {
            if (inorder[i] == root.val) {
                root.left = helper(preorder, inorder, inorderLb, i);
                root.right = helper(preorder, inorder, i + 1, inorderUb);
            }
        }
        
        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, inorder.length);
    }
}
