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
 * @param {number[]} inorder
 * @return {TreeNode}
 */
const buildTree = function (preorder, inorder) {
  const rootNodes = {};
  for (let i = 0; i < inorder.length; i++) {
    rootNodes[inorder[i]] = i;
  }

  const constructTree = (start, end) => {
    const rootVal = preorder[0];

    if (rootNodes[rootVal] >= start && rootNodes[rootVal] <= end) {
      const node = new TreeNode(rootVal);

      preorder.shift();

      node.left = constructTree(start, rootNodes[rootVal] - 1);
      node.right = constructTree(rootNodes[rootVal] + 1, end);

      return node;
    } else {
      return null;
    }
  };

  const head = constructTree(0, inorder.length);

  return head;
};
