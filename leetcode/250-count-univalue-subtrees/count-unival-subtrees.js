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
const countUnivalSubtrees = function (root) {
  let count = 0;

  if (!root) {
    return 0;
  }

  const helper = (root, parentVal) => {
    if (!root) {
      return true;
    }

    if (!helper(root.left, root.val) | !helper(root.right, root.val)) {
      return false;
    }

    count++;

    return root.val === parentVal;
  };

  helper(root, root.val);

  return count;
};
