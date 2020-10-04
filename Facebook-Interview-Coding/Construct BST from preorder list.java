Construct BST from preorder list

// 这个方法是“Construct BST from given preorder traversal”的O(n)解法，使用 MIN-MAX 思想，此题还有O(n^2)解法。
// 参见 http://www.geeksforgeeks.org/construct-bst-from-given-preorder-traversa/
public int idx = 0;
private TreeNode constructBST(int[] pre) {
    return constructBSTfromPreorder(pre, Integer.MIN_VALUE, Integer.MAX_VALUE);
}
private TreeNode constructBSTfromPreorder(int[] pre, int min, int max) {
    if (idx >= pre.length)  return null;
    if (pre[idx] <= min || pre[idx] >= max)     return null;
    TreeNode root = new TreeNode(pre[idx++]);
    root.left = constructBSTfromPreorder(pre, min, root.val);
    root.right = constructBSTfromPreorder(pre, root.val, max);
    return root;
}

// For example, if the given traversal is {10, 5, 1, 7, 40, 50}, 
// then the output should be root of following tree.
//      10
//    /   \
//   5     40
//  /  \      \
// 1    7      50