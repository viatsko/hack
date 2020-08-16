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
    private Map<Integer, List<TreeNode>> memo = new HashMap<>();
    
    public List<TreeNode> allPossibleFBT(int N) {
        if (memo.containsKey(N)) {
            return memo.get(N);
        }
        
        List<TreeNode> result = new LinkedList<>();
        if (N == 1) {
            result.add(new TreeNode(0));
            return result;
        }
        for (int i = 1; i < N; i += 2) {
            for (TreeNode left: allPossibleFBT(i)) {
                for (TreeNode right: allPossibleFBT(N - i - 1)) {
                    TreeNode node = new TreeNode(0);
                    node.left = left;
                    node.right = right;
                    result.add(node);
                }
            }
        }
        
        memo.put(N, result);
        
        return result;
    }
}
