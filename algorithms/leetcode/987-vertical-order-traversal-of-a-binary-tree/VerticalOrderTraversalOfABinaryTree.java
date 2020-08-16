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
    int leftMost = 0;
    int rightMost = 0;
    
    Map<Integer, List<TreeNode>> resultMap = new HashMap<>();
    Map<TreeNode, Integer> nodePositions = new HashMap<>();
    
    private void helper(TreeNode root, int level, int depth) {
        if (root == null) {
            return;
        }
        
        nodePositions.put(root, depth);
        
        leftMost = Math.min(level, leftMost);
        rightMost = Math.max(level, rightMost);
        
        List<TreeNode> currentList = resultMap.get(level);
        if (currentList == null) {
            currentList = new LinkedList<>();
            resultMap.put(level, currentList);
        }
        
        currentList.add(root);
        
        helper(root.left, level - 1, depth + 1);
        helper(root.right, level + 1, depth + 1);
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        helper(root, 0, 0);
        
        List<List<Integer>> result = new LinkedList<>();
        
        for (int i = leftMost; i <= rightMost; i++) {
            List<TreeNode> currentList = resultMap.get(i);
            
            Collections.sort(currentList, (a, b) -> {
                int ay = nodePositions.get(a);
                int by = nodePositions.get(b);
                int ydiff = ay - by;
                if (ydiff == 0) {
                    return a.val - b.val;
                }
                return ydiff;
            });
            
            List<Integer> currentResultList = new LinkedList<>();
            for (TreeNode node : currentList) {
                currentResultList.add(node.val);
            }
            
            result.add(currentResultList);
        }

        return result;
    }
}
