/**
 * // Definition for a Node.
 * function Node(val, left, right, next) {
 *    this.val = val === undefined ? null : val;
 *    this.left = left === undefined ? null : left;
 *    this.right = right === undefined ? null : right;
 *    this.next = next === undefined ? null : next;
 * };
 */

/**
 * @param {Node} root
 * @return {Node}
 */
const connect = function (root) {
  if (!root) {
    return null;
  }

  const q = [root];

  while (q.length) {
    const size = q.length;

    let prev = null;
    for (let i = 0; i < size; i++) {
      const curr = q.shift();
      if (prev) prev.next = curr;
      prev = curr;
      curr.left && q.push(curr.left);
      curr.right && q.push(curr.right);
    }
  }

  return root;
};
