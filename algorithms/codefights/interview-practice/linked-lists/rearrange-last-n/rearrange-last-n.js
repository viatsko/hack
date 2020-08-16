function rearrangeLastN(l, n) {
    const head = l;
    let prev;
    let slow = l;
    let fast = l;

    if (n === 0) {
        return head;
    }

    for (let i = 0; i < n - 1; i++) {
        fast = fast.next;
    }

    if (!fast.next) {
        return head;
    }

    while(fast.next) {
        fast = fast.next;

        prev = slow;

        slow = slow.next;
    }

    prev.next = null;
    fast.next = head;

    return slow;
}
