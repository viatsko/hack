
const mergeTrees = (t1, t2) => {
    if (!t1 && !t2) {
        return null;
    }
    
    const root = new TreeNode((t1 ? t1.val : 0) + (t2 ? t2.val : 0));
    
    root.left = mergeTrees(t1 ? t1.left : null, t2 ? t2.left : null);
    root.right = mergeTrees(t1 ? t1.right: null, t2 ? t2.right : null);
    
    return root;
}
