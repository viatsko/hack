/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {number[]} preorder
 * @return {TreeNode}
 */
var bstFromPreorder = function(preorder, R) {
  if (R !== undefined && preorder[0] > R || !preorder.length) {
    console.log(preorder[0], "rejected");
    return null;
  }

  const node = new TreeNode(preorder.shift());

  node.left = bstFromPreorder(preorder, node.val);
  node.right = bstFromPreorder(preorder, R);

  return node;
};
