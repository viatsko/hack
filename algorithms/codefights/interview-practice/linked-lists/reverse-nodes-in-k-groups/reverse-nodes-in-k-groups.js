function reverseNodesInKGroups(l, k) {
    function toArray(list) {
        const result = [];

        let node = list;

        while(node) {
            result.push(node.value);
            node = node.next;
        }

        return result;
    }

    let result;
    let resultlast;
    let node = l;
    while(node) {
        let current = node;
        let fast = current;

        for(let i=0;i<k - 1;i++) {
            fast = fast.next;

            if (!fast) {
                resultlast.next = current;
                return toArray(result)
            }
        }

        node = fast.next;
        fast.next = null;

        let prev;
        let next = current;

        while(next) {
            const tmp = next.next;
            next.next = prev;
            prev = next;
            next = tmp;
        }

        if (result) {
            resultlast.next = prev;
        } else {
            result = prev;
        }

        resultlast = current;
    }

    return toArray(result)
}
