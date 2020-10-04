235. Lowest Common Ancestor of Binary Search Tree

(1) with parent pointer
// https://www.careercup.com/question?id=56769
// http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=176715
follow up是如果两个节点靠的很近怎么办，这样如果树的height太高，这样就需要把所有的ancestors都遍历一遍，我想了半天，不过最后还是想出来了，
只要边存边查就可以了，不用先全部遍历把所有ancestors都存到hashSet里，他说cool，然后就是问问题。（注意考虑一下如果有一个节点是Null，或者两个节点不在同一个tree里怎么办）

Solution 1: Hashset ( Time: O(h), Space: O(h) )
public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	Set<TreeNode> ancestors = new HashSet<>();
	while (p != null || q != null) {
		if (p != null) {
			if (!ancestors.add(p))	return p;
			p = p.parent;
		}
		if (q != null) {
			if (!ancestors.add(q))	return q;
			q = q.parent;
		}
	}
	return null;
}

Solution 2: depth ( Time: O(h), Space: O(1) )
public static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
	int h1 = getHeight(p), h2 = getHeight(q);
	if (h1 < h2) {
		int tmp = h1;
		h1 = h2;
		h2 = tmp;
		TreeNode t = p;
		p = q;
		q = t;
	}
	int deltaH = h1 - h2;
	while (deltaH-- > 0) 
		p = p.parent;
	while (p != null && q != null) {
		if (p == q)		return p;
		p = p.parent;
		q = q.parent;
	}
	return null;
}
private static int getHeight(TreeNode node) {
	int height = 0;
	while (node != null) {
		node = node.parent;
		height++;
	}
	return height;
}

(2) without parent pointer
Solution 1: iteration

public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    while ((root.val - p.val) * (root.val - q.val) > 0)
        root = p.val < root.val ? root.left : root.right;
    return root;
}

Solution 2: recursion

public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {        
    if ((root.val - p.val) * (root.val - q.val) <= 0) return root;
    else if (p.val < root.val)
        return lowestCommonAncestor(root.left, p, q);
    else 
        return lowestCommonAncestor(root.right, p, q);
}


-------------------------------------------
236. Lowest Common Ancestor of Binary Tree

// Recursively expands the meaning of the function. If the current (sub)tree contains both p and q, then the function result 
// is their LCA. If only one of them is in that subtree, then the result is that one of them. If neither are in that subtree, 
// the result is null.

public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) return root;
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    return left == null ? right : right == null ? left : root;
}









