/**
 * // Definition for a Node.
 * function Node(val, left, right) {
 *      this.val = val;
 *      this.left = left;
 *      this.right = right;
 *  };
 */

/**
 * @param {Node} root
 * @return {Node}
 */
const treeToDoublyList = function (root) {
  if (!root) {
    return root;
  }

  const s = [];

  let prev = null;
  let head = null;

  while (root || s.length) {
    if (root) {
      s.push(root);
      root = root.left;
    } else {
      root = s.pop();

      const tmp = root.right;

      const node = root;

      if (prev === null) {
        head = node;
      }

      if (prev) prev.right = node;
      node.left = prev;
      prev = node;

      root = tmp;
    }
  }

  prev.right = head;
  head.left = prev;

  return head;
};
