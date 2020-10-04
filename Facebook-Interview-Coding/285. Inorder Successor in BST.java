285. Inorder Successor in BST
写完之后，面试官不太满意，觉得如果树很大的话，时间复杂度太高，然后交流了一下，发现面试官想要的答案是，TreeNode可以带parent指针的，输入只有一个TreeNode，没有root。所以一定要和面试官好好交流，写代码之前问清楚输入输出是什么才行。。
Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a binary search tree. You may assume that each node has a link to its parent.

TreeNode没有parent引用：

下面两种解法本质一样，都是充分利用BST的性质。
Solution 1: iteration (4ms)
// The idea is to compare root's value with p's value if root is not null, and consider the following two cases:
// root.val > p.val. In this case, root can be a possible answer, so we store the root node first and call it res. However, we don't know if there is anymore node on root's left that is larger than p.val. So we move root to its left and check again.
// root.val <= p.val. In this case, root cannot be p's inorder successor, neither can root's left child. So we only need to consider root's right child, thus we move root to its right and check again.
// We continuously move root until exhausted. To this point, we only need to return the res in case 1.'

public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    TreeNode res = null;
    while (root != null) {
        if (root.val > p.val) {
            res = root;
            root = root.left;
        } else     root = root.right;
    }
    return res;
}

Solution 2: recursion (5ms)
上面那种方法也可以写成递归形式，写法也比较简洁，但是需要把思路理清，当根节点值小于等于p节点值，说明p的后继节点一定在右子树中，所以对右子节点递归调用此函数，如果根节点值大于p节点值，那么有可能根节点就是p的后继节点，或者左子树中的某个节点是p的后继节点，所以先对左子节点递归调用此函数，如果返回空，说明根节点是后继节点，返回即可，如果不为空，则将那个节点返回。这种解法可以用作模板，求BST的inorder successor和predecessor


模板 [BST InOrder Successor / Predecessor]
// successor
public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    if (root == null)   return null;
    if (root.val > p.val) {
        TreeNode left = inorderSuccessor(root.left, p);
        return left == null ? root : left;
    } else    return inorderSuccessor(root.right, p);
}

// predecessor
public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
    if (root == null)   return null;
    if (root.val < p.val) {
        TreeNode right = inorderSuccessor(root.right, p);
        return right == null ? root : right;
    } else    return inorderPredecessor(root.left, p);
}


2. TreeNode有parent引用：

Pseudocode
   if n has a right subtree
	return leftmost child of right subtree
   else
	while n is a right child of n.parent
         n = n.parent  // go northwest till end
	return n.parent // return 1st northeast node

public TreeNode inOrderSuccessor(TreeNode n) {
	if (n == null)	return null;
	if (n.right != null)	
          return leftMostChild(n.right);
	else {
	    TreeNode cur = n, p = n.parent;
	    while (p != null && p.left != cur) {
            cur = p;
            p = p.parent;
	    }
	    return p;
      }
}
private TreeNode leftMostChild(TreeNode node) {
    while (node.left != null) 
        node = node.left;
    return node;
}



