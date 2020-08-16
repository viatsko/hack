class MovingAverage {
    /**
     * Initialize your data structure here.
     * @param {number} size
     */
    constructor(size) {
        this.queue = [];
        this.capacity = size;
    }

    /**
     * @param {number} val
     * @return {number}
     */
    next(val) {
        this.queue.push(val);

        if (this.queue.length > this.capacity) {
            this.queue.shift();
        }

        return this.queue.reduce((prev, next) => {
            return prev + next;
        }, 0) / this.queue.length;
    }
}
