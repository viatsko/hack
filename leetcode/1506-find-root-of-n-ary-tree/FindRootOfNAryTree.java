/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;


    public Node() {
        children = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }

    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
  public Node findRoot(List<Node> tree) {
    Set<Node> allNodes = new HashSet<>();
    Set<Node> children = new HashSet<>();

    for (Node node : tree) {
      allNodes.add(node);
      for (Node child: node.children) {
        children.add(child);
      }
    }

    allNodes.removeAll(children);

    return allNodes.iterator().next();
  }
}
