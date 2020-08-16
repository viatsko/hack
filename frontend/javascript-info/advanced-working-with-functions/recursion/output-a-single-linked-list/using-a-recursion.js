function printList(node) {
    if (!node) {
        return;
    }

    process.stdout.write(`${node.value}\n`);

    printList(node.next);
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
