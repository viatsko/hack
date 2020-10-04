98. Validate Binary Search Tree
// https://leetcode.com/problems/validate-binary-search-tree/

Solution 1: inorder + prev

Integer prev = null;
public boolean isValidBST(TreeNode root) {
	if (root == null)	return true;
	if（!isValidBST(root.left))		return false;
	if (prev != null && prev >= root.val)	return false;
	prev = root.val;
	if (!isValidBST(root.right))	return false;
	return true;
}




Solution 2: MIN - MAX check

注意return的写法

public boolean isValidBST(TreeNode root) {
	return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
}
private boolean checkBST(TreeNode root, long min, long max) {
	if (root == null)	return true;
	if (root.val <= min || root.val >= max)		return false;
	return checkBST(root.left, min, root.val) && checkBST(root.right, root.val, max);
 // if (!checkBST(root.left, min, root.val))    return false;
 // if (!checkBST(root.right, root.val, max))   return false;
 // return true;
}