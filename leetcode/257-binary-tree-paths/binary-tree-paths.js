
const binaryTreePaths = root => {
    const results = [];
    
    const traverse = (root, path) => {
        if (!root) {
            return;
        }
        
        path = typeof path === 'undefined' ? String(root.val) : `${path}->${root.val}`;
        
        if (!root.left && !root.right) {
            results.push(path);
        } else {
            traverse(root.left, path);
            traverse(root.right, path);
        }
    }
    
    traverse(root);
    
    return results;
}
