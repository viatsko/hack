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
    class Ref<T>{
        public T value;
        
        public Ref(T val) {
            value = val;
        }
    }
    
    private TreeNode bstFromPreorderHelper(int[] preorder, Ref<Integer> currentIndex, int lowerBound, int upperBound) {
        if (currentIndex.value >= preorder.length) {
            return null;
        }
        
        int value = preorder[currentIndex.value];
        
        if (value < lowerBound || value > upperBound) {
            return null;
        }
        
        TreeNode root = new TreeNode(value);
        currentIndex.value++;
        root.left = bstFromPreorderHelper(preorder, currentIndex, lowerBound, value);
        root.right = bstFromPreorderHelper(preorder, currentIndex, value, upperBound);
        
        return root;
    }
    
    public TreeNode bstFromPreorder(int[] preorder) {
        Ref<Integer> currentIndex = new Ref<>(0);
        return bstFromPreorderHelper(preorder, currentIndex, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
