const deleteDuplicates = head => {
    let start = new ListNode(0);
    start.next = head;

    let node = start;
    while(node && node.next && node.next.next) {
        if (node.next.val === node.next.next.val) {
            const valToRemove = node.next.val;

            while(node.next && node.next.val === valToRemove) {
                node.next = node.next.next;
            }
        } else {
            node = node.next;
        }
    }

    return start.next;
};
