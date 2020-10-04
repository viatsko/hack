Longest Path in Binary Tree

给个2叉树， 找出从1个叶节点到另1个叶节点最长的路径，返回路径长度

Solution: post order

private int max = 0
public int longestPath(TreeNode root) {
	dfs(root);
	return max;
}
private int dfs(TreeNode root) {
	if (root == null)	return 0;
	int left = dfs(root.left);
	int right = dfs(root.right);
	max = Math.max(max, left + right + 1);
	return Math.max(left, right) + 1;
}

此题因为是返回最长长度的话，一定是从叶节点到叶节点，否则，就往叶节点延伸，可以取得更长的长度。
下题中是返回最大的和，有可能叶节点是负值，所以并不是一定从叶节点出发。但是这两题的解题思路可以是完全一样。



124. Binary Tree Maximum Path Sum

Given a binary tree, find the maximum path sum.
For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
Given the below binary tree,

       1
      / \
     2   3
      \
      -1
      /
     2
Return 7.


private int max = Integer.MIN_VALUE;
public int maxPathSum(TreeNode root) {
    dfs(root);
    return max;
}
private int dfs(TreeNode root) {
    if (root == null)   return 0;
    int left = Math.max(0, dfs(root.left));
    int right = Math.max(0, dfs(root.right));
    max = Math.max(max, left + right + root.val);
    return Math.max(left, right) + root.val;
}










