102. Binary Tree Level Order Traversal

Solution 1: BFS
Time: O(n)

public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null)  return res;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
        List<Integer> tmp = new ArrayList<>();
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            TreeNode node = queue.poll();
            tmp.add(node.val);
            if (node.left != null)     queue.offer(node.left);
            if (node.right != null)    queue.offer(node.right);
        }
        res.add(tmp);
    }
    return res;
}




Solution 2: DFS
Time: O(n)

public List<List<Integer>> levelOrder(TreeNode root) {    
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    dfs(res, root, 0);
    return res;
}
private void dfs(List<List<Integer>> res, TreeNode root, int level) {
    if (root == null)   return;
    if (level == res.size())    res.add(new ArrayList<>());
    res.get(level).add(root.val);
    dfs(res, root.left, level + 1);
    dfs(res, root.right, level + 1);
}




