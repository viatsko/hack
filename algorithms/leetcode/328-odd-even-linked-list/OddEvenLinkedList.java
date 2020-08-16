public class OddEvenLinkedList {
    public class ListNode {
        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = new ListNode(0);
        ListNode evenHead = new ListNode(0);

        ListNode oddNode = oddHead;
        ListNode evenNode = evenHead;

        ListNode node = head;
        while (node != null) {
            if (node.val % 2 == 0) {
                evenNode.next = new ListNode(node.val);
                evenNode = evenNode.next;
            } else {
                oddNode.next = new ListNode(node.val);
                oddNode = oddNode.next;
            }

            node = node.next;
        }

        oddNode.next = evenHead.next;

        return oddHead.next;
    }
}
