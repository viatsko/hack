class MinStack {
    constructor() {
        this.stack = [];
        this.min_stack = [];
    }
    
    /** 
     * @param {number} x
     * @return {void}
     */
    push(x) {
        this.stack.push(x);
        
        // kinda x < min_stack.top()
        if (this.min_stack.length === 0 || x <= this.min_stack[this.min_stack.length - 1]) {
            this.min_stack.push(x);
        }
    }

    /**
     * @return {void}
     */
    pop() {
        if (this.min_stack[this.min_stack.length - 1] === this.top()) {
            this.min_stack.pop();
        }
        
        this.stack.pop();
    }

    /**
     * @return {number}
     */
    top() {
        return this.stack[this.stack.length - 1];
    }

    /**
     * @return {number}
     */
    getMin() {
        return this.min_stack[this.min_stack.length - 1];
    }
}
