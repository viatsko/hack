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
    private TreeNode bstFromPreorder(TreeNode node, int value) {
        if (node == null) {
            return new TreeNode(value);
        } else {
            if (value > node.val) {
                node.right = bstFromPreorder(node.right, value);
            } else if (value < node.val) {
                node.left = bstFromPreorder(node.left, value);
            }
        }
        
        return node;
    }
    
    public TreeNode bstFromPreorder(int[] preorder) {
        int currentIndex = 0;
        
        if (preorder.length == 0) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[0]);
        
        for (int i = 1; i < preorder.length; i++) {
            root = bstFromPreorder(root, preorder[i]);
        }
        
        return root;
    }
}
