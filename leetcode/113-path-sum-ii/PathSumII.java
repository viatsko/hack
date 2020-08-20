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
    private void helper(List<List<Integer>> result, List<Integer> currentPath, TreeNode root, int sum) {
        if (root == null)
            return;
        
        currentPath.add(root.val);
        
        if (root.left == null && root.right == null) {
            if (sum - root.val == 0) {
                result.add(new LinkedList<Integer>(currentPath));
            }
        } else {
            helper(result, currentPath, root.left, sum - root.val);
            helper(result, currentPath, root.right, sum - root.val);
        }
        
        currentPath.remove(currentPath.size() - 1);
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<>();
        
        List<Integer> currentPath = new ArrayList<>();
        
        helper(result, currentPath, root, sum);
        
        return result;
    }
}
