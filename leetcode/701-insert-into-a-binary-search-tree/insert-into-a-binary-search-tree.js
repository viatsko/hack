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
 * @param {number} val
 * @return {TreeNode}
 */
var insertIntoBST = function(root, val) {
  if (!root) {
    return new TreeNode(val);
  }

  let ins = false;

  var traverse = function(node) {
    if (ins || !node) {
      return;
    }

    if (!node.left && val < node.val) {
      node.left = new TreeNode(val);
      ins = true;
    } else if (!node.right && val > node.val) {
      node.right = new TreeNode(val);
      ins = true;
    }

    if (val < node.val) {
      traverse(node.left);
    }
    if (val > node.val) {
      traverse(node.right);
    }
  };

  traverse(root);

  return root;
};
