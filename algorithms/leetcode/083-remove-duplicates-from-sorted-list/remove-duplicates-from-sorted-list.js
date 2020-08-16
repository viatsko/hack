const deleteDuplicates = head => {
    let node = head;

    while(node) {
        while(node.next !== null && node.next.val === node.val) {
            node.next = node.next.next;
        }

        node = node.next;
    }

    return head;
};
