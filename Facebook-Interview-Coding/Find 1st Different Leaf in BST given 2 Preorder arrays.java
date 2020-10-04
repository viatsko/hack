Given two pre-order traversal arrays of two binary search tree respectively, find first pair of non-matching leaves. 

思路：先建树，然后再找leaf
Time: O(n)

private static int idx;
public int[] findNotMatchingLeaf(int[] pre1, int[] pre2){
    TreeNode root1 = constructBST(pre1);
    TreeNode root2 = constructBST(pre2);
    List<TreeNode> leaves1 = new ArrayList<>();
    List<TreeNode> leaves2 = new ArrayList<>();
    getLeaves(leaves1, root1);
    getLeaves(leaves2, root2);
    int[] res = new int[2];
    for (int i = 0; i < Math.min(leaves1.size(), leaves2.size()); i++) 
        if (leaves1.get(i).val != leaves2.get(i).val) {
            res[0] = leaves1.get(i).val;
            res[1] = leaves2.get(i).val;
            return res;
        }
    return res;
}
// 这个方法是“Construct BST from given preorder traversal”的O(n)解法，使用 MIN-MAX 思想，此题还有O(n^2)解法。
// 参见 http://www.geeksforgeeks.org/construct-bst-from-given-preorder-traversa/
private TreeNode constructBST(int[] pre) {
    idx = 0;
    return constructBSTfromPreorder(pre, Integer.MIN_VALUE, Integer.MAX_VALUE);
}
private static TreeNode constructBSTfromPreorder(int[] pre, int min, int max) {
    if (idx >= pre.length)  return null;
    if (pre[idx] <= min || pre[idx] >= max)     return null;
    TreeNode root = new TreeNode(pre[idx++]);
    root.left = constructBSTfromPreorder(pre, min, root.val);
    root.right = constructBSTfromPreorder(pre, root.val, max);
    return root;
}
private void getLeaves(List<TreeNode> res, TreeNode root) {
    if (root == null)   return;
    if (root.left == null && root.right == null) {
        res.add(root);
        return;
    }
    getLeaves(res, root.left);
    getLeaves(res, root.right);
}




Follow Up: If they are general binary trees instead of BSTs, could you solve it? give out your reason.

Time: O(n)

public int[] findNotMatchingLeaf(String pre1, String pre2){    
    int[] res = new int[2];
    String[] str1 = pre1.split("null, null");
    String[] str2 = pre2.split("null, null");
    for (int i = 0;i < Math.min(str1.length(), str2.length()); i++){
        char c1 = str1[i].charAt(str1[i].length() - 2);
        char c2 = str2[i].charAt(str2[i].length() - 2); //逗号
        if(c1 != c2){
            res[0] = c1 - '0';
            res[1] = c2 - '0';
            return res;
        }
    }
    return res;
}
