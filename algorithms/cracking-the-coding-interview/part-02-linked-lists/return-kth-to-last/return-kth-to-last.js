const returnKthToLast = (head, k) => {

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
