class MovingAverage {
    /**
     * Initialize your data structure here.
     * @param {number} size
     */
    constructor(size) {
        this.arr = new Array(3).fill(0);
        this.size = 0;
        this.idx = 0;
        this.total = 0;
        this.capacity = size;
    }

    /**
     * @param {number} val
     * @return {number}
     */
    next(val) {
        if (this.size < this.capacity) {
            this.size++;
        }

        const idx = this.idx % 3;

        this.total -= this.arr[idx];
        this.total += val;

        this.arr[idx] = val;

        this.idx++;

        return this.total / this.size;
    }
}
