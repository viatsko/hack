function addTwoHugeNumbers(a, b) {
    function reverseList(next) {
        let prev;

        while(next) {
            const tmp = next.next;
            next.next = prev;
            prev = next;
            next = tmp;
        }

        return prev;
    }

    a = reverseList(a);
    b = reverseList(b);

    let c;
    let cur;
    let buf = 0;

    while(a || b) {
        let sum = (a ? a.value : 0) + (b ? b.value : 0);

        sum += buf;
        buf = 0;

        if (sum >= 10000) {
            buf = Math.floor(sum / 10000);
            sum = sum % 10000;
        }

        if (!c) {
            c = new ListNode(sum);
            cur = c;
        } else {
            cur.next = new ListNode(sum);
            cur = cur.next;
        }

        if (a) a = a.next;
        if (b) b = b.next;
    }

    if (buf) {
        cur.next = new ListNode(buf);
        cur = cur.next;
    }

    c = reverseList(c);

    const res = [];

    while(c) {
        res.push(c.value);
        c = c.next;
    }

    return res;
}
