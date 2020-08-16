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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        
        q.offer(root);
        
        int max = Integer.MIN_VALUE;
        int answer = 0;
        int level = 0;
        while (!q.isEmpty()) {
            int levelCount = q.size();
            
            int levelSum = 0;
            
            while (levelCount-- > 0) {
                TreeNode current = q.poll();
                levelSum += current.val;
                
                if (current.left != null)
                    q.offer(current.left);
                
                if (current.right != null)
                    q.offer(current.right);
            }
            
            if (levelSum > max) {
                max = levelSum;
                answer = level + 1;
            }
            
            level++;
        }
        
        return answer;
    }
}
