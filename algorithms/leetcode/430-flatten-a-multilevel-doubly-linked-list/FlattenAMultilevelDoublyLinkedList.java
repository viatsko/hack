/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
  public Node[] flattenCore(Node head) {
    Node prev = null;
    Node node = head;

    while (node != null) {
      if (node.child != null) {
        Node[] flattened = flattenCore(node.child);

        Node begin = flattened[0];
        Node end = flattened[1];

        node.child = null;

        if (node.next != null) {
          node.next.prev = end;
        }

        end.next = node.next;

        begin.prev = node;
        node.next = begin;

        node = end;
      }

      prev = node;
      node = node.next;
    }

    return new Node[]{
      head,
      prev // tail
    };
  }

  public Node flatten(Node head) {
    return flattenCore(head)[0];
  }
}
