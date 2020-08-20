const removeNthFromEnd = (head, n) => {
    let node = new ListNode(0);

    node.next = head;

    let fast = node;
    let slow = node;

    for (let i = 0; i < n; i++) {
        fast = fast.next;
    }

    while(fast.next) {
        slow = slow.next;
        fast = fast.next;
    }

    slow.next = slow.next.next;

    return node.next;
};
