/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {number[]} inorder
 * @param {number[]} postorder
 * @return {TreeNode}
 */
const buildTree = function (inorder, postorder) {
  const rootNodes = {};
  for (let i = 0; i < inorder.length; i++) {
    rootNodes[inorder[i]] = i;
  }

  const constructTree = (start, end) => {
    const rootVal = postorder[postorder.length - 1];

    if (rootNodes[rootVal] >= start && rootNodes[rootVal] <= end) {
      const node = new TreeNode(rootVal);

      postorder.pop();

      node.right = constructTree(rootNodes[rootVal] + 1, end);
      node.left = constructTree(start, rootNodes[rootVal] - 1);

      return node;
    } else {
      return null;
    }
  };

  const head = constructTree(0, inorder.length);

  return head;
};
