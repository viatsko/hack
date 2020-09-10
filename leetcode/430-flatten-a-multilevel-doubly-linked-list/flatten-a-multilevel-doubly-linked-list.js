/**
 * // Definition for a Node.
 * function Node(val,prev,next,child) {
 *    this.val = val;
 *    this.prev = prev;
 *    this.next = next;
 *    this.child = child;
 * };
 */

/**
 * @param {Node} head
 * @return {Node}
 */
const flatten = function (head) {
  let node = head;

  while (node) {
    if (!node.child) {
      node = node.next;
    } else {
      let last = node.child;
      while (last.next) {
        last = last.next;
      }
      last.next = node.next;
      if (node.next) node.next.prev = last;

      node.next = node.child;
      node.child.prev = node;
      node.child = null;
    }
  }

  return head;
};
