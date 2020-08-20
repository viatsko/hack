const isPalindrome = head => {
    const reverse = node => {
        let prev = null;

        while (node) {
            const tmp = node.next;
            node.next = prev;
            prev = node;
            node = tmp;
        }

        return prev;
    };

    let slow = head;
    let fast = head;

    while (fast && fast.next) {
        slow = slow.next;
        fast = fast.next.next;
    }

    let start = head;
    let reversed = reverse(slow);

    while (reversed) {
        if (reversed.val !== start.val) {
            return false;
        }

        start = start.next;
        reversed = reversed.next;
    }

    return true;
};
