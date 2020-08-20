const reverseKGroup = (head, k) => {
    // for some reason, leetcode wants array as an output,
    // not list,
    // so this function transforms list to array
    const toArray = list => {
        const result = [];
        let node = list;

        while(node) {
            result.push(node.val);
            node = node.next;
        }

        return result;
    };

    let result;
    let last;
    let node = head;

    while(node) {
        const slow = node;
        let fast = node;

        for (let i = 0; i < k - 1; i++) {
            fast = fast.next;

            if (!fast) {
                if (!result) {
                    return toArray(slow);
                } else {
                    last.next = slow;

                    return toArray(result);
                }
            }
        }

        node = fast.next;
        fast.next = null;

        let newtail = slow;
        let cur = slow;
        let prev;

        while(cur) {
            const tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }

        if (result) {
            last.next = prev;
        } else {
            result = prev;
        }

        last = newtail;
    }

    return toArray(result);
};
