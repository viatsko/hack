class MyLinkedList {
  class Node {
    public int val;
    public Node next;

    public Node(int val) {
      this.val = val;
    }
  }

  private Node head;

  /** Initialize your data structure here. */
  public MyLinkedList() {

  }

  private Node seekTo(int index) {
    Node node = head;

    while (index-- > 0 && node != null) {
      node = node.next;
    }

    return node;
  }

  /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
  public int get(int index) {
    Node node = seekTo(index);

    if (node == null) {
      return -1;
    }

    return node.val;
  }

  /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
  public void addAtHead(int val) {
    if (head == null) {
      head = new Node(val);
    } else {
      Node node = new Node(val);
      node.next = head;
      head = node;
    }
  }

  /** Append a node of value val to the last element of the linked list. */
  public void addAtTail(int val) {
    if (head == null) {
      head = new Node(val);
    } else {
      Node node = head;

      while (node.next != null) {
        node = node.next;
      }

      node.next = new Node(val);
    }
  }

  /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
  public void addAtIndex(int index, int val) {
    if (index == 0) {
      addAtHead(val);
    } else {
      Node node = seekTo(index - 1);

      if (node == null) {
        return;
      }

      Node ins = new Node(val);
      ins.next = node.next;
      node.next = ins;
    }
  }

  /** Delete the index-th node in the linked list, if the index is valid. */
  public void deleteAtIndex(int index) {
    Node node = seekTo(index - 1);
    if (node != null && node.next != null) {
      node.next = node.next.next;
    }
  }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
