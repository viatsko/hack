/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} val
 * @return {TreeNode}
 */
const searchBST = function (root, val) {
  let node = root;
  while (node) {
    if (val < node.val) {
      node = node.left;
    } else if (val > node.val) {
      node = node.right;
    } else {
      return node;
    }
  }
  return node;
};
