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
var pseudoPalindromicPaths = function (root, path) {
  if (!root) {
    return 0;
  }

  if (!path) {
    path = {};
  }

  if (path[root.val] !== undefined) {
    delete path[root.val];
  } else {
    path[root.val] = true;
  }

  if (!root.left && !root.right) {
    if (Object.keys(path).length <= 1) {
      return 1;
    } else {
      return 0;
    }
  }

  return (
    pseudoPalindromicPaths(root.left, { ...path }) +
    pseudoPalindromicPaths(root.right, { ...path })
  );
};
