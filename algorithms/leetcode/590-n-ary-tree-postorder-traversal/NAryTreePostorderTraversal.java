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
  public List<Integer> postorder(Node root) {
    List<Integer> result = new LinkedList<>();

    if (root == null) {
      return result;
    }

    Stack<Node> stack = new Stack<>();

    stack.push(root);

    while (!stack.empty()) {
      Node node = stack.pop();

      result.add(0, node.val);

      for (Node child : node.children) {
        stack.push(child);
      }
    }

    return result;
  }
}
