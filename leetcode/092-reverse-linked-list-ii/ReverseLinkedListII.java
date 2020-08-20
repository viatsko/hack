/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        
        ListNode prestart = null;
        ListNode startNode = fakeHead;
        int start = 0;
        while (start++ < m) {
            prestart = startNode;
            startNode = startNode.next;
        }

        ListNode prev = null;
        ListNode current = startNode;
        while (start++ <= n + 1) {
            ListNode tmp = current.next;
            current.next = prev;
            prev = current;
            current = tmp;
        }
        
        prestart.next = prev;
        startNode.next = current;
        
        return fakeHead.next;
    }
}
