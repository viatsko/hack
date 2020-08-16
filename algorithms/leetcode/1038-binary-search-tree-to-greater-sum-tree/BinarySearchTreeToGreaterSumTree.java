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
    class Ref<T>
    {
        public T val;

        public Ref(T value)
        {
            val = value;
        }
    }
    
    public TreeNode bstToGst(TreeNode root) {
        Ref<Integer> sum = new Ref<>(0);
        bstToGst(root, sum);
        return root;
    }
    
    private void bstToGst(TreeNode root, Ref<Integer> sum) {
        if (root.right != null)
            bstToGst(root.right, sum);
        
        sum.val += root.val;
        root.val = sum.val;
        
        if (root.left != null)
            bstToGst(root.left, sum);
    }
}
