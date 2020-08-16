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
    int maxDepth = -1;
    Map<Integer,Integer> depth = new HashMap<>();
    
    private void fillInDepthMap(TreeNode root, int depth) {
        if (root == null) return;
        
        maxDepth = Math.max(maxDepth, depth);
        
        fillInDepthMap(root.left, depth + 1);
        fillInDepthMap(root.right, depth + 1);
    }
    
    private TreeNode findDeepest(TreeNode root, int depth) {
        if (root == null || depth == maxDepth) {
            return root;
        }
        
        TreeNode left = findDeepest(root.left, depth + 1);
        TreeNode right = findDeepest(root.right, depth + 1);
        
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        } else {
            return null;
        }
    }
    
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        fillInDepthMap(root, 0);       
        return findDeepest(root, 0);
    }
}
