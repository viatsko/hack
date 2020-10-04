257. Binary Tree Paths 

Time: O(nlogn)

public List<String> binaryTreePaths(TreeNode root) {
	List<String> res = new ArrayList<>();
	dfs(res, root, "");
	return res;
}
private void dfs(List<String> res, TreeNode root, String tmp) {
	if (root == null)	return;
	if (root.left == null && root.right == null)
		res.add(tmp + root.val);
	dfs(res, root.left, tmp + root.val + "->");
	dfs(res, root.right, tmp + root.val + "->");
}

考虑print path
1 如果所有的node在一条线上，时间复杂度。O(n^2)
2 full binary tree 时间复杂度。O(nlogn)
3 优化时间复杂度：StringBuilder

// iterative (dfs pre-order) 两个stack: 一个treenode，一个stringbuilder
public List<String> binaryTreePaths(TreeNode root) {
    List<String> res = new ArrayList<>();
    if (root == null)    return res;
    Stack<TreeNode> stack = new Stack<>();
    Stack<StringBuilder> paths = new Stack<>();
    stack.push(root);
    paths.push(new StringBuilder(root.val + ""));//remember to add + "" !!!
    while (!stack.empty()) {
        TreeNode node = stack.pop();
        StringBuilder path = paths.pop();
        if (node.left == null && node.right == null) 
            res.add(path.toString());
        if (node.right != null) {
            stack.push(node.right);
            StringBuilder newPath = new StringBuilder(path);
            paths.push(newPath.append("->").append(node.right.val));
        }
        if (node.left != null) {
            stack.push(node.left);
            StringBuilder newPath = new StringBuilder(path);
            paths.push(newPath.append("->").append(node.left.val));
        }
    }
    return res;
}


*****Follow Up1****
If we cannot use dfs(which is easy for printing paths)
then use bfs, use hashmap to store parent-to-children paths

public void binaryTreePaths(TreeNode root) {
    List<String> res = new ArrayList<>();
    if (root == null)    return res;
    HashMap<TreeNode, TreeNode> map = new HashMap<>(); // (node, parent node)
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    map.put(root, null);
    while (!queue.isEmpty()) {
        TreeNode curr = queue.poll();
        if (curr.left == null && curr.right == null) {
            String path = getPath(map, curr);//if you only want to print paths, we can use recursion here
            res.add(path);
        }
        if (curr.left != null) {
            map.put(curr.left, curr);
            queue.offer(curr.left);
        }
        if (curr.right != null) {
            map.put(curr.right, curr);
            queue.offer(curr.right);
        }
    }
    return res;
}
private String getPath(HashMap<TreeNode, TreeNode> map, TreeNode node) {
    StringBuilder sb = new StringBuilder();
    while (node != null) {//from leaf to root
        sb.append(node.val + ">-");
        node = map.get(node);
    }
    return sb.reverse().substring(2);
}


// iterative (bfs), use queue to store ArrayList<TreeNode>, which is the path
public List<String> binaryTreePaths(TreeNode root) {
    List<String> res = new ArrayList<>();
    if (root == null)    return res;
    Queue<ArrayList<TreeNode>> queue = new LinkedList<>();
    queue.offer(new ArrayList<>(Arrays.asList(root)));
    while (!queue.isEmpty()) {
        ArrayList<TreeNode> path = queue.poll();
        TreeNode curr = path.get(path.size() - 1);
        if (curr.left == null && curr.right == null) {
            StringBuilder sb = new StringBuilder();
            for (TreeNode node : path) 
                sb.append(node.val + "->");
            sb.setLength(sb.length() - 2);//it's void type !!!
            res.add(sb.toString());
            continue;
        }
        if (curr.left != null) {
            ArrayList<TreeNode> newPath = new ArrayList<>(path);
            newPath.add(curr.left);
            queue.offer(newPath);
        }
        if (curr.right != null) {
            ArrayList<TreeNode> newPath = new ArrayList<>(path);
            newPath.add(curr.right);
            queue.offer(newPath);
        }
    }
    return res;
}



******变种*****
比如有一个 root to leaf path 是 1 2 5 2，target 是2，那么这个 path 就应该打印成 1 1 2 5 1 2 5 2。每次遇到 2 就把前面的路径重新 append 一下: 1 (1 2) 5 (1 2 5 2).

public List<String> binaryTreePaths(TreeNode root,int target) {
    List<String> res = new ArrayList<>();
    if (root == null) 	return res;
    helper(res, root, "", "", target);
    return res;
}
public void helper(List<String> res, TreeNode root, String s, String target_s, int target){
	if (root == null)	return;
    if (root.left == null && root.right == null)
        if (root.val == target)
            res.add(target_s + s + root.val);
        else 	res.add(target_s + root.val);
    if (root.val == target) {
        helper(res, root.left, s + root.val + "->", target_s + s + root.val + "->", target);
        helper(res, root.right, s + root.val + "->", target_s + s + root.val + "->", target);
    } else {
    	helper(res, root.left, s + root.val + "->", target_s + root.val + "->", target);
	    helper(res, root.right, s + root.val + "->", target_s + root.val + "->", target);
	}
}



