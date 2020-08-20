
class RandomizedSet {
    constructor() {
        this.count = 0;
        this.values = {};
        this.keys = {};
    }
    
    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element. 
     * @param {number} val
     * @return {boolean}
     */
    insert(val) {
        if (Object.prototype.hasOwnProperty.call(this.values, val)) {
            return false;
        }
        
        this.values[val] = this.count;
        this.keys[this.count] = val;
        this.count++;
        
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element. 
     * @param {number} val
     * @return {boolean}
     */
    remove(val) {
        if (!Object.prototype.hasOwnProperty.call(this.values, val)) {
            return false;
        }
            
        if (this.values[val] === this.count - 1) {
            delete this.values[val];
            delete this.keys[this.count - 1];
        } else {
            const idx = this.values[val];
            
            this.keys[idx] = this.keys[this.count - 1];
            this.values[this.keys[this.count - 1]] = idx;
            delete this.values[val];
            delete this.keys[this.count - 1];
        }
        
        this.count--;
        
        return true;
    }

    /**
     * Get a random element from the set.
     * @return {number}
     */
    getRandom() {
        return this.keys[Math.floor(Math.random() * this.count)];
    } 
}
