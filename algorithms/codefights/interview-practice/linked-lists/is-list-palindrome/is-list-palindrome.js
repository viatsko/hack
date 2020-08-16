function isListPalindrome(l) {
    let head = l;
    let slow = l;
    let fast = l;

    while(fast && fast.next) {
        slow = slow.next;
        fast = fast.next.next;
    }

    let node = slow;
    let rev = null;

    while(node) {
        const tmp = node.next;
        node.next = rev;
        rev = node;
        node = tmp;
    }

    while(rev) {
        if (head.value !== rev.value) {
            return false;
        }

        head = head.next;
        rev = rev.next;
    }

    return true;
}
