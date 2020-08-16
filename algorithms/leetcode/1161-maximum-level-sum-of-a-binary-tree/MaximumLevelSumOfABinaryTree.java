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
    Map<Integer, Integer> sums = new HashMap<>();
    
    public int maxLevelSum(TreeNode root) {
        helper(root, 1);
        
        int max = Integer.MIN_VALUE;
        int maxLevel = Integer.MIN_VALUE;
        
        for (Map.Entry<Integer, Integer> entry : sums.entrySet()) {
            int value = entry.getValue();
            if (value > max) {
                max = value;
                maxLevel = entry.getKey();
            }
        }
        
        return maxLevel;
    }
    
    private void helper(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        
        int sum = sums.getOrDefault(level, 0) + root.val;
        sums.put(level, sum);
        
        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }
}
