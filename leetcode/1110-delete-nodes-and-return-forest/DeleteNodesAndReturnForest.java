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
    private void helper(TreeNode root, int depth, Set<Integer> toDelete, List<TreeNode> result) {
        if (root == null) {
            return;
        }
        
        if (depth == 0 && !toDelete.contains(root.val)) {
            result.add(root);
        }
        
        
        // meh
        if (root.left != null) {
            if (toDelete.contains(root.val) || toDelete.contains(root.left.val)) {
                TreeNode left = root.left;
                root.left = null;
                helper(left, 0, toDelete, result);
            } else {
                helper(root.left, depth + 1, toDelete, result);
            }
        }
        
        if (root.right != null) {
            if (toDelete.contains(root.val) || toDelete.contains(root.right.val)) {
                TreeNode right = root.right;
                root.right = null;
                helper(right, 0, toDelete, result);
            } else {
                helper(root.right, depth + 1, toDelete, result);
            }
        }
    }
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> toDelete = IntStream.of(to_delete).boxed().collect(Collectors.toCollection(HashSet::new));
        
        List<TreeNode> result = new LinkedList<>();
        
        helper(root, 0, toDelete, result);
        
        return result;
    }
}
