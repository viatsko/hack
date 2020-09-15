/**
 * // Definition for a Node.
 * function Node(val, children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */

/**
 * @param {Node} root
 * @return {number[]}
 */
const preorder = function (root) {
  if (!root) {
    return [];
  }

  const q = [root];

  const result = [];

  while (q.length) {
    const node = q.shift();
    if (node.children) {
      q.unshift(...node.children);
    }
    result.push(node.val);
  }

  return result;
};
