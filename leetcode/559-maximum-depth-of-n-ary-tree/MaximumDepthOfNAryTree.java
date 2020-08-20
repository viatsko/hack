/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
  public int traverse(Node node, int level) {
    if (node == null) {
      return level;
    }

    int max = level;

    for (Node child : node.children) {
      max = Math.max(traverse(child, level + 1), max);
    }

    return max;
  }

  public int maxDepth(Node root) {
    if (root == null) {
      return 0;
    }

    return traverse(root, 1);
  }
}
