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
  public List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> result = new LinkedList<>();

    if (root == null) {
      return result;
    }

    Queue<Node> q1 = new LinkedList<>();
    Queue<Node> q2 = new LinkedList<>();

    Queue<Node> q;
    Queue<Node> rq;

    q1.add(root);

    while(!q1.isEmpty() || !q2.isEmpty()) {
      List<Integer> current = new LinkedList<>();

      if (q2.isEmpty()) {
        q = q1;
        rq = q2;
      } else {
        q = q2;
        rq = q1;
      }

      while (!q.isEmpty()) {
        Node node = q.remove();

        for (Node child : node.children) {
          rq.add(child);
        }

        current.add(node.val);
      }

      result.add(current);
    }

    return result;
  }
}
