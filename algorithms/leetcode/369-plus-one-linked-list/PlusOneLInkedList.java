/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode prev = null;
        ListNode node = head;
        
        while (node != null) {
            ListNode tmp = node.next;
            node.next = prev;
            prev = node;
            node = tmp;
        }
        
        head = null;
        node = prev;
        int carry = 1;
        while (node != null) {
            node.val += carry;
            if (node.val == 10) {
                carry = 1;
                node.val = 0;
            } else {
                carry = 0;
            }
            ListNode tmp = node.next;
            node.next = head;
            head = node;
            node = tmp;
        }
        
        if (carry == 1) {
            ListNode oneHead = new ListNode(carry);
            oneHead.next = head;
            head = oneHead;
        }
        
        return head;
    }
}