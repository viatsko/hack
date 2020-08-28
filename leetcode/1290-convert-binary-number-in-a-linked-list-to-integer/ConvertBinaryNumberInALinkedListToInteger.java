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
  int depth = 1;
  public int getDecimalValue(ListNode head) {
    if (head.next != null) {
      int res = getDecimalValue(head.next);
      depth *= 2;
      res += head.val * depth;
      return res;
    } else {
      return head.val;
    }
  }
}
