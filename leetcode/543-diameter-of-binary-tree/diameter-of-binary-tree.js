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
const diameterOfBinaryTree = function (root) {
  let result = 0;

  const helper = (node) => {
    if (!node) {
      return 0;
    }

    const left = helper(node.left);
    const right = helper(node.right);

    result = Math.max(left + right, result);

    return Math.max(left, right) + 1;
  };

  helper(root);

  return result;
};
