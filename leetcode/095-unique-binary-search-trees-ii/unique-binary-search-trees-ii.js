/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {number} n
 * @return {TreeNode[]}
 */
const generateTrees = function (n) {
  if (n === 0) {
    return [];
  }

  const nodes = [];
  for (let i = 1; i <= n; i++) {
    nodes.push(i);
  }

  const genTrees = (start, end) => {
    const result = [];

    if (start === end) {
      return [null];
    }

    for (let i = start; i < end; i++) {
      const leftTrees = genTrees(start, i);
      const rightTrees = genTrees(i + 1, end);

      for (const leftTree of leftTrees) {
        for (const rightTree of rightTrees) {
          const root = new TreeNode(nodes[i]);
          root.left = leftTree;
          root.right = rightTree;
          result.push(root);
        }
      }
    }

    return result;
  };

  return genTrees(0, nodes.length);
};
