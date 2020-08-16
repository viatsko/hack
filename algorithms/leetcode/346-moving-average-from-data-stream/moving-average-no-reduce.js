class MovingAverage {
    /**
     * Initialize your data structure here.
     * @param {number} size
     */
    constructor(size) {
        this.queue = [];
        this.total = 0;
        this.capacity = size;
    }

    /**
     * @param {number} val
     * @return {number}
     */
    next(val) {
        this.queue.push(val);

        this.total += val;

        if (this.queue.length > this.capacity) {
            this.total -= this.queue.shift();
        }

        return this.total / this.queue.length;
    }
}
