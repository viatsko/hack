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
        T value;
        
        public Ref(T val) {
            value = val;
        }
    }
    
    private TreeNode helper(String S, Ref<Integer> currentPosition, int level) {
        int index = currentPosition.value;
        
        int newLevel = 0;
        while(index < S.length() && S.charAt(index) == '-') {
            newLevel++;
            index++;
        }
        
        if (newLevel != level) {
            return null;
        }

        int value = 0;
        
        while(index < S.length() && S.charAt(index) != '-') {
            value = value * 10 + S.charAt(index++) - '0';
        }
        
        currentPosition.value = index;
        
        TreeNode root = new TreeNode(value);
        
        root.left = helper(S, currentPosition, level + 1);
        root.right = helper(S, currentPosition, level + 1);
        
        return root;
    }

    public TreeNode recoverFromPreorder(String S) {
        Ref<Integer> currentPosition = new Ref<>(0);
        
        return helper(S, currentPosition, 0);
    }
}
