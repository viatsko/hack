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
 * @param {number} target
 * @return {number}
 */
const closestValue = function (node, target) {
  let closestDist = Number.MAX_SAFE_INTEGER;
  let closestNodeValue;

  while (node) {
    const dist = Math.abs(node.val - target);

    if (dist < closestDist) {
      closestDist = dist;
      closestNodeValue = node.val;
    }

    if (node.val > target) {
      node = node.left;
    } else if (node.val < target) {
      node = node.right;
    } else if (node.val === target) {
      return node.val;
    }
  }

  return closestNodeValue !== undefined ? closestNodeValue : null;
};
