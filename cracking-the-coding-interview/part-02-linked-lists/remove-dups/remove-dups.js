const removeDups = head => {
    let node = head;

    while(node) {
        let runner = node;

        while(runner && runner.next) {
            while (runner.next && runner.next.val === node.val) {
                runner.next = runner.next.next;
            }

            runner = runner.next;
        }

        node = node.next;
    }

    return head;
};

class Node {
    constructor(val) {
        this.val = val;
        this.next = null;
    }
}

const arrayToLL = arr => {
    const head = new Node(arr[0]);

    let node = head;

    for (let i = 1; i < arr.length; i++) {
        node = node.next = new Node(arr[i]);
    }

    return head;
};

const llToArray = node => {
    const result = [];

    while(node) {
        result.push(node.val);
        node = node.next;
    }

    return result;
};

console.log(llToArray(removeDups(arrayToLL([2, 2, 2, 2, 0, 0, 2, 3, 4, 5, 3, 3, 6, 7, 2, 1, 0]))));
console.log(llToArray(removeDups(arrayToLL([2, 2, 2, 2]))));
