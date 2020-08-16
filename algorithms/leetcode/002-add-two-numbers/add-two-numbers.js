const addTwoNumbers = (l1, l2) => {
    let result,  // linked list for the result
        node,    // current node, basically last element of a result linked-list
        buf = 0; // buffer to keep remainder (numbers can be 0 to 9 in this problem)

    while(l1 || l2 || buf) {
        let sum = (l1 ? l1.val : 0) + (l2 ? l2.val : 0) + buf;

        if (sum >= 10) {
            buf = Math.floor(sum / 10);
            sum = sum % 10;
        } else {
            buf = 0;
        }

        if (!result) {
            result = new ListNode(sum);
            node = result;
        } else {
            node = node.next = new ListNode(sum);
        }

        if (l1) l1 = l1.next;
        if (l2) l2 = l2.next;
    }

    return result;
};
