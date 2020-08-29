/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
  public ListNode deleteNodes(ListNode head, int m, int n) {
    ListNode root = new ListNode(0);
    root.next = head;
    ListNode node = root;

    while (node != null) {
      for (int i = 0; node != null && i < m; i++) {
        node = node.next;
      }

      if (node == null) {
        break;
      }

      ListNode cloned = node;
      for (int i = 0; node != null && cloned != null && i <= n; i++) {
        cloned = cloned.next;
      }

      node.next = cloned;
    }

    return root.next;
  }
}
