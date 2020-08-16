const getIntersectionNode = (headA, headB) => {
    const countListNodes = node => {
        let count = 0;

        while (node) {
            count++;
            node = node.next;
        }

        return count;
    };

    let lenA = countListNodes(headA);
    let lenB = countListNodes(headB);

    if (lenA > lenB) {
        for (let i = 0; i < lenA - lenB; i++) {
            headA = headA.next;
        }
    }

    if (lenB > lenA) {
        for (let i = 0; i < lenB - lenA; i++) {
            headB = headB.next;
        }
    }

    while(headA && headB) {
        if (headA === headB) {
            return headA;
        }

        headA = headA.next;
        headB = headB.next;
    }

    return null;
};
