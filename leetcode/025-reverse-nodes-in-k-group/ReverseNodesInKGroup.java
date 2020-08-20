/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode current = head;
    ListNode next = null;
    ListNode prev = null;

    ListNode tmpCurrent = current;
    int count = 0;
    while (count++ < k && tmpCurrent != null) {
      tmpCurrent = tmpCurrent.next;
    }

    if (count <= k) {
      return head;
    }

    count = 0;
    while (count++ < k && current != null) {
       next = current.next;
       current.next = prev;
       prev = current;
       current = next;
    }

    if (next != null) {
      head.next = reverseKGroup(next, k);
    }

    return prev;
  }
}
