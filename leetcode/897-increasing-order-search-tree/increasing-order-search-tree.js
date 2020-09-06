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
 * @return {TreeNode}
 */
var increasingBST = function (root) {
  let newHead = null;
  let head = newHead;

  let node = root;

  const arr = [];

  while (node) {
    while (node.left) {
      arr.push(node);
      node = node.left;
      arr[arr.length - 1].left = null;
    }

    if (newHead === null) {
      newHead = head = new TreeNode(node.val);
    } else {
      head.right = new TreeNode(node.val);
      head = head.right;
    }

    if (node.right) {
      node = node.right;
    } else {
      node = arr.pop();
    }
  }

  return newHead;
};
