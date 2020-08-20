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
    private void helper(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        
        if (level + 1 > result.size()) {
            result.add(new ArrayList<>());
        }
        
        result.get(level).add(root.val);
        
        helper(root.left, level + 1, result);
        helper(root.right, level + 1, result);
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        helper(root, 0, result);
        
        return result;
    }
}
