/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val,Node _next) {
        val = _val;
        next = _next;
    }
};
*/
class Solution {
  public Node insert(Node head, int insertVal) {
    Node result;

    // if head is empty
    if (head == null) {
      result = new Node();
      result.val = insertVal;
      result.next = result;

      return result;
    }

    // searching start/end
    Node start;
    Node end = head;

    while (end.next.val > end.val) {
      end = end.next;
    }

    start = end.next;

    if (insertVal <= start.val || insertVal >= end.val) {
      result = new Node(insertVal, start);
      start = result;
      end.next = start;
    } else {
      while (insertVal > start.next.val) {
        start = start.next;
      }

      result = new Node(insertVal, start.next);
      start.next = result;
    }

    return start;
  }
}
