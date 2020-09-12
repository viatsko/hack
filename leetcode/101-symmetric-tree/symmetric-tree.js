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
const isSymmetric = function (root) {
  if (!root) {
    return true;
  }

  return validateMirroredTrees(root.left, root.right);
};

const validateMirroredTrees = function (tree1, tree2) {
  if (!tree1 && !tree2) {
    return true;
  }

  if (!tree1 || !tree2) {
    return false;
  }

  if (tree1.val !== tree2.val) {
    return false;
  }

  return (
    validateMirroredTrees(tree1.left, tree2.right) &&
    validateMirroredTrees(tree1.right, tree2.left)
  );
};
