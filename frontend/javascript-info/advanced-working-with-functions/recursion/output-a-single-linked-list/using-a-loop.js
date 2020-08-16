function printList(head) {
    let node = head;

    while(node) {
        process.stdout.write(`${String(node.value)}\n`);
        node = node.next;
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
