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
const balanceBST = function (root) {
  return buildTree(inOrderTreeToArray(root));
};

const buildTree = (arr) => {
  if (!arr.length) {
    return null;
  }

  if (arr.length === 1) {
    return new TreeNode(arr.pop());
  }

  const mid = arr.length >>> 1;

  const root = new TreeNode(arr[mid]);
  root.left = buildTree(arr.slice(0, mid));
  root.right = buildTree(arr.slice(mid + 1));

  return root;
};

const inOrderTreeToArray = (root) => {
  if (root === null) {
    return [];
  }

  return [
    ...inOrderTreeToArray(root.left),
    root.val,
    ...inOrderTreeToArray(root.right),
  ];
};
