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
  const q1 = [tree1];
  const q2 = [tree2];

  while (q1.length || q2.length) {
    if (!q1.length || !q2.length) {
      return false;
    }

    const curr1 = q1.shift();
    const curr2 = q2.shift();

    if (
      (curr1 === null && curr2 !== null) ||
      (curr2 === null && curr1 !== null) ||
      (curr1 && curr2 && curr1.val !== curr2.val)
    ) {
      return false;
    }

    if (curr1) {
      q1.push(curr1.left);
      q1.push(curr1.right);
    }
    if (curr2) {
      q2.push(curr2.right);
      q2.push(curr2.left);
    }
  }

  return true;
};
