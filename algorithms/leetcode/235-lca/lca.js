
const lowestCommonAncestor = (root, p, q) => {
    const lca = node => {
        if (node.val > p.val && node.val > q.val) {
            return lca(node.left);
        }

        if (node.val < p.val && node.val < q.val) {
            return lca(node.right);
        }

        return node;
    }

    return lca(root);
}
