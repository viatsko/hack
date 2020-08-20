/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */

/**
 * @param {TreeNode} root
 * @param {number} v
 * @param {number} d
 * @return {TreeNode}
 */
const addOneRow = function(root, v, d) {
  if (!root) {
    return root;
  }

  if (d === 1) {
    const newNode = new TreeNode(v);
    newNode.left = root;
    return newNode;
  }

  const traverse = function(node, curDepth) {
    if (!node) {
      return;
    }

    if (curDepth === d) {
      const newNodeLeft = new TreeNode(v);
      newNodeLeft.left = node.left;
      node.left = newNodeLeft;

      const newNodeRight = new TreeNode(v);
      newNodeRight.right = node.right;
      node.right = newNodeRight;

      return;
    }

    traverse(node.left, curDepth + 1);
    traverse(node.right, curDepth + 1);
  };

  traverse(root, 2);

  return root;
};
