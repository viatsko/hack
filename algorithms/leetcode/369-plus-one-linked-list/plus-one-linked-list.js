const plusOne = head => {
    if (!head) {
        return null;
    }

    let prev = null;

    while(head) {
        const tmp = head.next;
        head.next = prev;
        prev = head;
        head = tmp;
    }

    let leftover = 1;

    head = null;

    while(prev) {
        const tmp = prev.next;
        prev.next = head;

        prev.val += leftover;

        if (prev.val >= 10) {
            leftover = 1;
            prev.val -= 10;
        } else {
            leftover = 0;
        }

        head = prev;
        prev = tmp;
    }

    if (leftover) {
        const tmp = new ListNode(leftover);
        tmp.next = head;
        head = tmp;
    }

    return head;
};
