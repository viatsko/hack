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
 * @return {number}
 */
const sumRootToLeaf = function (root, sum = 0) {
  if (root == null) {
    return 0;
  }

  const newSum = (sum << 1) + root.val;

  if (!root.left && !root.right) {
    return newSum;
  }

  return sumRootToLeaf(root.left, newSum) + sumRootToLeaf(root.right, newSum);
};
