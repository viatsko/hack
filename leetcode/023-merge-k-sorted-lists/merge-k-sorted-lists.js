const mergeKLists = (lists) => {
    if (!lists.length) {
        return null;
    }

    if (lists.length === 1) {
        return lists[0];
    }

    const mergeTwoLists = (l1, l2) => {
        let root = new ListNode(0);
        let node = root;

        while (l1 && l2) {
            if (l1.val < l2.val) {
                node = node.next = l1;
                l1 = l1.next;
            } else {
                node = node.next = l2;
                l2 = l2.next;
            }
        }

        node.next = l1 ? l1 : l2;

        return root.next;
    };

    let list = lists[0];

    for (let i = 1; i < lists.length; i++) {
        list = mergeTwoLists(list, lists[i]);
    }

    return list ? list : [];
};
