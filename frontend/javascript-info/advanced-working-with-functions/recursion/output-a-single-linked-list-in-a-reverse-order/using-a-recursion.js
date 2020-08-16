function printList(node) {
    if (!node) {
        return;
    }

    printList(node.next);

    process.stdout.write(`${node.value}\n`);
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
