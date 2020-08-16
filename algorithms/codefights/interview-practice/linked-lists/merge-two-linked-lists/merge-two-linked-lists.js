function mergeTwoLinkedLists(l1, l2) {
    let head;
    let res;
    let next;

    if (!l1) {
        return l2;
    } else if (!l2) {
        return l1;
    }

    while(l1 || l2) {
        if (!l1) {
            res.next = l2;
            return head;
        } else if (!l2) {
            res.next = l1;
            return head;
        }

        if (l1.value < l2.value) {
            next = l1;
            l1 = l1.next;
        } else {
            next = l2;
            l2 = l2.next;
        }

        if (!res) {
            head = res = next;
        } else {
            res.next = next;
            res = res.next;
        }
    }

    return head;
}
