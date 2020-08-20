const partition = (head, x) => {
    let lower = new ListNode(0);
    let higher = new ListNode(0);

    let lowerNode = lower;
    let higherNode = higher;

    let node = head;
    while(node) {
        if (node.val < x) {
            lowerNode.next = node;
            lowerNode = lowerNode.next;
        } else {
            higherNode.next = node;
            higherNode = higherNode.next;
        }

        node = node.next;
    }

    higherNode.next = null;
    lowerNode.next = higher.next;

    return lower.next;
};
