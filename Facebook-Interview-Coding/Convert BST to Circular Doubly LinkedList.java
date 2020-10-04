Convert BST to Circular Doubly LinkedList
// http://articles.leetcode.com/convert-binary-search-tree-bst-to/

注意，head和prev必须用全局变量！！

// we could safely modify a node’s left pointer to point to the previously traversed node as we never use it once we reach a node. 
// We would also need to modify the previously traversed node’s right pointer to point to the current node.
// But wait, we are still missing two more steps. First, we did not assign the list’s head pointer. Second, the last element’s right pointer does not point to the first element (similar to the first element’s left pointer).
// Just update the current node’s right pointer to point back to the head and the head’s left pointer to point to current node in each recursive call. 
// As the recursion ends, the list’s head and tail would be automagically updated with the correct pointers. 
// Don’t forget to check for this special case: A list with only one element should have its left and right pointers both pointing back to itself.

Solution 1: recursion
O(n) time, O(h) space

TreeNode head = null, prev = null;
public TreeNode convertBSTtoCircularDL(TreeNode root) {
	convert(root);
	return head;
}
public void convert(TreeNode root) {
	if (root == null)	return;
	convert(root.left);
	root.left = prev;
	if (prev != null)	prev.right = root;
	else	head = root;
	// would make head <-> tail in the end
	TreeNode right = root.right;
	head.left = root;
	root.right = head;
	prev = root;
	convert(right);
}



Solution 2: iteration
O(n) time, O(h) space

public TreeNode bstToDoublyList(TreeNode root) {  
    TreeNode head = null, prev = null;
    Stack<TreeNode> stack = new Stack<>();
    while (root != null || !stack.empty()) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        root = stack.pop();
        root.left = prev;
        if (prev != null)	prev.right = root;
        else 	head = root;
        TreeNode right = root.right;
        head.left = root;
        root.right = head;//remember to update the prev !!!
        prev = root;
        root = right;//we should root=root.right even if it's null!!!
    }
    return head;
}
