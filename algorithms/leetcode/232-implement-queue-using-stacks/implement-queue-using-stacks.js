class MyQueue {
    /**
     * Initialize your data structure here.
     */
    constructor() {
        this.head = [];
        this.tail = [];
    }

    /**
     * Push element x to the back of queue.
     * @param {number} x
     * @return {void}
     */
    push(x) {
        this.tail.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     * @return {number}
     */
    pop() {
        this.peek();

        return this.head.pop();
    }

    /**
     * Get the front element.
     * @return {number}
     */
    peek() {
        if (!this.head.length) {
            while(this.tail.length) {
                this.head.push(this.tail.pop());
            }
        }

        return this.head[this.head.length - 1];
    }

    /**
     * Returns whether the queue is empty.
     * @return {boolean}
     */
    empty() {
        return !this.head.length && !this.tail.length;
    }
}
