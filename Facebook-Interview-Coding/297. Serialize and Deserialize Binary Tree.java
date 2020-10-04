297. Serialize and Deserialize Binary Tree

// Encodes a tree to a single string.
public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    buildString(root, sb);
    return sb.toString();
}
public void buildString(TreeNode root, StringBuilder sb) {
    if (root == null)   sb.append("#").append(" ");
    else {
        sb.append(root.val).append(" ");
        buildString(root.left, sb);
        buildString(root.right, sb);
    }
}
// Decodes your encoded data to tree.
public TreeNode deserialize(String data) {
    Queue<String> q = new LinkedList<>();
    q.addAll(Arrays.asList(data.split(" ")));
    return buildTree(q);
}
public TreeNode buildTree(Queue<String> q) {
    String s = q.remove();
    if (s.equals("#"))   return null;
    TreeNode root = new TreeNode(Integer.valueOf(s));
    root.left = buildTree(q);
    root.right = buildTree(q);
    return root;
}