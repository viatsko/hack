
class NestedIterator {
    /**
     * @constructor
     * @param {NestedInteger[]} nestedList
     */
    constructor(nestedList) {
        this.list = nestedList;
        this.current;
    }
    
    /**
     * @this NestedIterator
     * @returns {boolean}
     */
    hasNext() {
        let el;
        
        while (el = this.list.shift()) {
            if (Array.isArray(el)) {
                this.list.unshift(...el);
            } else if (!el.isInteger()) {
                this.list.unshift(...el.getList());
            } else {
                break;
            }
        }
        
        this.current = el;
        
        return el instanceof NestedInteger;
    }
    
    /**
     * @this NestedIterator
     * @returns {integer}
     */
    next() {
        return this.current.getInteger();
    }
}
