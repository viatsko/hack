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
 * @return {number}
 */
var goodNodes = function (root, max) {
  if (!root) {
    return 0;
  }

  let res = 0;

  if (max === undefined) {
    res += 1;
    max = root.val;
  } else if (root.right >= max) {
    res += 1;
  }

  max = Math.max(max, root.val);

  return res + goodNodes(root.left, max) + goodNodes(root.right, max);
};
