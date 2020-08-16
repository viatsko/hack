function printList(head) {
    let node = head;
    let prev = null;

    while(node) {
        const tmp = node.next;
        node.next = prev;
        prev = node;
        node = tmp;
    }

    while(prev) {
        process.stdout.write(`${prev.value}\n`);
        prev = prev.next;
    }
}

let list = {
    value: 1,
    next: {
        value: 2,
        next: {
            value: 3,
            next: {
                value: 4,
                next: null
            }
        }
    }
};

printList(list);
