
class Node {
    constructor(key, val) {
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

/**
 * @param {number} capacity
 */
class LRUCache {
    constructor(capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = null;
        this.tail = null;
        this.mp = new Map();
    }

    /** 
     * @param {number} key
     * @return {number}
     */
    get(key) {
        const node = this.mp.get(key);
        
        if (!node) {
            return -1;
        }
        
        this.moveTop(node);
        
        return node.val;
    }
    
    moveTop(node) {
        if (this.head.key !== node.key) {
            if (this.tail === node && this.head !== node) {
                this.tail = node.prev;
            } else {
                if (node.next) {
                    node.next.prev = node.prev;
                }
                
                if (node.prev) {
                    node.prev.next = node.next;
                }
            }

            node.next = this.head;
            node.prev = null;
            this.head.prev = node;
            this.head = node;
        }
    }

    /** 
     * @param {number} key 
     * @param {number} value
     * @return {void}
     */
    put(key, value) {
        if (this.capacity === 0) return;
        
        let node = this.mp.get(key);
        
        if (node) {
            node.val = value;
            
            this.moveTop(node);
            
            return;
        }
        
        node = new Node(key, value);
        this.mp.set(key, node);
        
        if (!this.head) {
            this.head = this.tail = node;
        } else {
            this.moveTop(node);
        }
        
        this.size++;
        
        if (this.size > this.capacity) {
            this.mp.delete(this.tail.key);
            this.tail = this.tail.prev;
            this.size--;
        }
    }
}
