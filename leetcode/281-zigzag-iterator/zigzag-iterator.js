
class ArrayIterator {
    constructor(arr) {
        this.index = 0;
        this.length = arr.length;
        this.arr = arr;
    }
    
    hasNext() {
        return this.index < this.arr.length;
    }
    
    next() {
        return this.arr[this.index++];
    }
}

class ZigzagIterator {
    /**
     * @constructor
     * @param {Integer[]} v1
     * @param {Integer[]} v1
     */
    constructor(v1, v2) {
        this.i1 = new ArrayIterator(v1);
        this.i2 = new ArrayIterator(v2);
        this.cur = this.i1.hasNext() ? this.i1 : this.i2;
    }

    /**
     * @this ZigzagIterator
     * @returns {boolean}
     */
    hasNext() {
        return this.cur.hasNext();
    }

    /**
     * @this ZigzagIterator
     * @returns {integer}
     */
    next() {
        if (!this.hasNext()) {
            return false;
        }
        
        let result = this.cur.next();
        
        this.cur = (this.cur === this.i1 && this.i2.hasNext() || !this.i1.hasNext()) ? this.i2 : this.i1;
        
        return result;
    }
}
