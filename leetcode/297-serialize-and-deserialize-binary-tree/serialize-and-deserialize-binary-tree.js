
const serialize = root => {
    if (!root) {
        return [];
    }
    
    const result = [root.val];
    
    const inner = (node) => {
        if (!node) {
            return;
        }
        
        result.push(node.left ? node.left.val : null);
        result.push(node.right ? node.right.val : null);
        
        inner(node.left);
        inner(node.right);
    };
    
    inner(root);
    
    return result;
}

const deserialize = data => {
    if (data.length === 0) {
        return null;
    }
    
    const root = new TreeNode(data.shift());
    
    const inner = (node) => {
        if (!data.length) {
            return;
        }
        
        let l = data.shift();
        let r = data.shift();
        
        node.left = l !== null ? new TreeNode(l) : null;
        node.right = r !== null ? new TreeNode(r) : null;
        
        if (node.left) {
            inner(node.left);
        }
        
        if (node.right) {
            inner(node.right);
        }
    }
    
    inner(root);
    
    return root;
}
