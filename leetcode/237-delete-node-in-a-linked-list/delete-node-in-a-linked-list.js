
const deleteNode = node => {
    if (node.next) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
