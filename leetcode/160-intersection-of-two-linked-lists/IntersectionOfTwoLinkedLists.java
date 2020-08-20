/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = countNodes(headA);
        int lenB = countNodes(headB);
        
        if (lenA > lenB) {
            headA = skipNodes(headA, lenA - lenB);
        } else if (lenB > lenA) {
            headB = skipNodes(headB, lenB - lenA);
        }
        
        while(headA != null) {
            if (headA == headB) {
                return headA;
            }
            
            headA = headA.next;
            headB = headB.next;
        }
        
        return null;
    }
    
    private int countNodes(ListNode node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }
    
    private ListNode skipNodes(ListNode node, int k) {
        while (k-- > 0) {
            node = node.next;
        }
        
        return node;
    }
}
