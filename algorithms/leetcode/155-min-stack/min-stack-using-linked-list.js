class Node {
    constructor(val) {
        this.val = val;
        this.next = null;
    }
}

/**
 * initialize your data structure here.
 */
class MinStack {
    constructor() {
        this.size = 0;
        this.min = Number.POSITIVE_INFINITY;
        this.list = null;
        this.minList = null;
    }

    /**
     * @param {number} x
     * @return {void}
     */
    push(x) {
        this.size++;

        let node;

        node = new Node(x);
        node.next = this.list;
        this.list = node;

        this.min = Math.min(x, this.min);

        node = new Node(this.min);
        node.next = this.minList;
        this.minList = node;
    }

    /**
     * @return {void}
     */
    pop() {
        this.size--;
        this.list = this.list.next;
        if (this.minList.next) {
            this.min = this.minList.next.val;
        } else {
            this.min = Number.POSITIVE_INFINITY;
        }
        this.minList = this.minList.next;
    }

    /**
     * @return {number}
     */
    top() {
        return this.list.val;
    }

    /**
     * @return {number}
     */
    getMin() {
        return this.minList.val;
    }
}
