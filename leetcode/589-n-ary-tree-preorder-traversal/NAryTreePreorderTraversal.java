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
  public List<Integer> preorder(Node root) {
    List<Integer> result = new LinkedList<>();

    if (root == null) {
      return result;
    }

    Stack<Node> stack = new Stack<>();

    stack.push(root);

    while (!stack.empty()) {
      Node node = stack.pop();

      result.add(node.val);

      for (int i = node.children.size() - 1; i >= 0; i--) {
        stack.push(node.children.get(i));
      }
    }

    return result;
  }
}
