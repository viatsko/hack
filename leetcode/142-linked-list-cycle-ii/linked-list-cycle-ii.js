const detectCycle = head => {
    let slow = head;
    let fast = head;

    while(fast && fast.next) {
        slow = slow.next;
        fast = fast.next.next;

        if (slow === fast) {
            let start = head;

            while(start !== slow) {
                start = start.next;
                slow = slow.next;
            }

            return slow;
        }
    }

    return null;
};
