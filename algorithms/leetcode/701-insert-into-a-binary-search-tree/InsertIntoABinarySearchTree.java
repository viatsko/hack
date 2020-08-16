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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode nodeToInsert = new TreeNode(val);
        
        // given tree is empty, so node to insert will become a new tree
        if (root == null) {
            return nodeToInsert;
        }
        
        TreeNode prev = null;
        TreeNode node = root;
        while (node != null) {
            prev = node;
            if (node.val > val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        
        if (prev.val > val) {
            prev.left = nodeToInsert;
        } else {
            prev.right = nodeToInsert;
        }
        
        return root;
    }
}
