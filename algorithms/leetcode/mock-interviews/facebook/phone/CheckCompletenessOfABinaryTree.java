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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(q.peek() != null) {
            TreeNode node = q.poll();
            q.offer(node.left);
            q.offer(node.right);
        }
        
        while(!q.isEmpty() && q.peek() == null) {
            q.poll();
        }
        
        return q.isEmpty();
    }
}
