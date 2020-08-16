public class RemoveLinkedListElements {
    public class ListNode {
        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        while(head != null && head.val == val) {
            head = head.next;
        }

        ListNode node = head;

        while (node != null && node.next != null) {
            while (node.next != null && node.next.val == val) {
                node.next = node.next.next;
            }

            node = node.next;
        }

        return head;
    }
}
