/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */

function LeveledNode(node, level) {
  this.node = node;
  this.level = level;
}

/**
 * @param {TreeNode} root
 * @return {number[][]}
 */
const levelOrder = function (root) {
  if (!root) {
    return [];
  }

  const q = [new LeveledNode(root, 0)];
  const result = [];

  while (q.length) {
    const curr = q.shift();

    if (!result[curr.level]) result[curr.level] = [];

    result[curr.level].push(curr.node.val);

    if (curr.node.left) q.push(new LeveledNode(curr.node.left, curr.level + 1));
    if (curr.node.right)
      q.push(new LeveledNode(curr.node.right, curr.level + 1));
  }

  return result;
};
