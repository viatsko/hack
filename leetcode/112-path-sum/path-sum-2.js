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
 * @param {number} sum
 * @return {boolean}
 */
const hasPathSum = function (root, sum) {
  if (!root) {
    return false;
  }

  return hasPathSumHelper(root, sum);
};

const hasPathSumHelper = function (root, sum) {
  if (!root) {
    return false;
  }

  sum -= root.val;

  if (!root.left && !root.right) {
    return sum === 0;
  }

  return hasPathSumHelper(root.left, sum) || hasPathSumHelper(root.right, sum);
};
