/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @return {boolean}
 * @param tree1
 * @param tree2
 */
const isSameTree = function (tree1, tree2) {
  if (!tree1 && !tree2) {
    return true;
  }
  const q1 = tree1 ? [tree1] : [];
  const q2 = tree2 ? [tree2] : [];

  while (q1.length && q2.length) {
    const node1 = q1.shift();
    const node2 = q2.shift();

    if ((node1 === null || node2 === null) && node1 !== node2) {
      return false;
    }

    if (node1?.val !== node2?.val) {
      return false;
    }

    if (node1 && node2) {
      q1.push(node1.left);
      q2.push(node2.left);

      q1.push(node1.right);
      q2.push(node2.right);
    }
  }

  return !(q1.length || q2.length);
};
