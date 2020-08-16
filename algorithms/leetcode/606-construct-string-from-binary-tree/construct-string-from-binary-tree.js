
const tree2str = t => {
    if (!t) return '';

    return t.val +
        (t.left ? ('(' + tree2str(t.left)  + ')') : (t.right ? '()' : '')) +
        (t.right ? ('(' + tree2str(t.right)  + ')') : '');
}
