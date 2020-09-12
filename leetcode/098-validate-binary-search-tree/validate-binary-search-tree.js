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
 * @return {boolean}
 */
const isValidBST = function (root, min, max) {
  if (!root) {
    return true;
  }

  if (min === undefined) {
    min = Number.MIN_SAFE_INTEGER;
  }

  if (max === undefined) {
    max = Number.MAX_SAFE_INTEGER;
  }

  if (root.val >= max || root.val <= min) {
    return false;
  }

  return (
    isValidBST(root.left, min, root.val) &&
    isValidBST(root.right, root.val, max)
  );
};
