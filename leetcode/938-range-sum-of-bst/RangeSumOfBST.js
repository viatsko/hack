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
 * @param {number} L
 * @param {number} R
 * @return {number}
 */
var rangeSumBST = function(root, L, R) {
  if (!root) {
    return 0;
  }

  if (root.val < L) {
    return rangeSumBST(root.right, L, R);
  }
  if (root.val > R) {
    return rangeSumBST(root.left, L, R);
  }
  return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
};
