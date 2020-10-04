314. Binary Tree Vertical Order Traversal

class TreeNodeWithCol {
    TreeNode treeNode;
    int col;
    public TreeNodeWithCol(TreeNode node, int col) {
        this.treeNode = node;
        this.col = col;
    }
}
public List<List<Integer>> verticalOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null)   return res;
    Map<Integer, List<Integer>> map = new HashMap<>();
    Queue<TreeNodeWithCol> bfs = new ArrayDeque<>();
    bfs.add(new TreeNodeWithCol(root, 0));
    int max = 0, min = 0;
    while (!bfs.isEmpty()) {
        TreeNodeWithCol node = bfs.poll();
        int col = node.col;
        if (!map.containsKey(col))  map.put(col, new ArrayList<>());
        map.get(col).add(node.treeNode.val);
        if (node.treeNode.left != null) {
            bfs.offer(new TreeNodeWithCol(node.treeNode.left, col - 1));
            min = Math.min(min, col - 1);
        }
        if (node.treeNode.right != null) {
            bfs.offer(new TreeNodeWithCol(node.treeNode.right, col + 1));
            max = Math.max(max, col + 1);
        }
    }
    for (int i = min; i <= max; i++) 
        res.add(map.get(i));
    return res;
}

//If you wanna avoid using hashmap cuz of key conflicts,you can use doubly-linked list,each node stores a Arraylist of vals,
//then replace Queue<Integer> cols with Queue<LinkedList> cols,each time we poll,we first add it to curr node's arraylist,
//put non-null left node to a new left list(if curr.prev == head),
//put non-null right node to a new right list(if curr.next == tail),
//finally iterate all lists from head to tail