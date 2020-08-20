
const reverseList = head => {
    // for some reason, leetcode wants array as an output,
    // not list,
    // so this function transforms list to array
    const toArray = list => {
        const result = [];
        let node = list;
        
        while(node) {
            result.push(node.val);
            node = node.next;
        }
        
        return result;
    }
    
    // reversing of list is a simple swap with a tmp variable used to preserve
    // the next element while we do swap
    let node = head;
    let prev;
    
    while(node) {
        const tmp = node.next;
        node.next = prev;
        prev = node;
        node = tmp;
    }
    
    return toArray(prev);
};
