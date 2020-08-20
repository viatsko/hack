const addTwoNumbers = (l1, l2) => {
    const n1 = [];
    const n2 = [];

    while(l1) {
        n1.unshift(l1.val);
        l1 = l1.next;
    }

    while(l2) {
        n2.unshift(l2.val);
        l2 = l2.next;
    }

    let carry = 0;

    let node = null;

    while(n1.length || n2.length) {
        const sum = (n1.length ? n1.shift() : 0) + (n2.length ? n2.shift() : 0) + carry;

        let new_node = new ListNode(sum % 10);

        carry = Math.floor(sum / 10);

        new_node.next = node;

        node = new_node;
    }

    if (carry > 0) {
        let new_node = new ListNode(carry);

        new_node.next = node;

        node = new_node;
    }

    return node;
};
