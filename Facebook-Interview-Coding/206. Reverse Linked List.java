206. Reverse Linked List
// https://leetcode.com/problems/reverse-linked-list/

Solution 1: iterative
public ListNode reverseList(ListNode head) {
    ListNode newHead = null;
    while(head != null) {
        ListNode next = head.next;
        head.next = newHead;
        newHead = head;
        head = next;
    }
    return newHead;
}

Solution 2: recursive
public ListNode reverseList(ListNode head) {
    return helper(head, null);  
}
private ListNode helper(ListNode cur, ListNode newHead) {
    if (cur == null)    return newHead;
    ListNode next = cur.next;
    cur.next = newHead;
    return helper(next, cur);
}


变种：
print linkedlist reversely, recursive (print linked list, no reverse)
if cannot use recursion, cannot modify the linkedlist, we can use StringBuilder.reverse().toString()

1，递归：
public void reverseList(ListNode head) {
    if (head == null)    return;
    reverseList(head.next);
    System.out.print(head.val + " ");
}

2,非递归：
public void print(ListNode head){
    Stack<ListNode> stack = new Stack<>();
    while (head != null) {
        stack.push(head);
        head = head.next;
    }
    while (!stack.isEmpty()) 
        System.out.println(stack.poll().val);
}

Follow Up:
if we need to use O(logn) space ? we can use recursion to print the right part, and then the left part

Solution: D & C     
O(nlogn) time, O(logn) space

public void reverseList(ListNode head) {
    if (head == null)    return;
    ListNode curr = head;
    int length = 0;
    while (curr != null) {//get the total length
        curr = curr.next;
        length++;
    }
    helper(head, length);
}
private void helper(ListNode head, int length) {
    if (length == 1) {
        System.out.print(head.val + " ");
        return;//remember to return !!!
    }
    ListNode curr = head;
    int count = 0;
    while (count < length / 2) {
        curr = curr.next;
        count++;
    }
    helper(curr, length - length / 2);//note that the right part has length - length / 2 nodes
    helper(head, length / 2);
}

