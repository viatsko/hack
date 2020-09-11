/**
 * // Definition for a Node.
 * function Node(val, next) {
 *     this.val = val;
 *     this.next = next;
 * };
 */

/**
 * @param {Node} head
 * @param {number} insertVal
 * @return {Node}
 */
const insert = function (head, insertVal) {
  if (head === null) {
    const node = new Node(insertVal);
    node.next = node;
    return node;
  }

  end = head;
  while (end.next.val >= end.val && end.next !== head) {
    end = end.next;
  }

  let start = end.next;

  if (insertVal <= start.val || insertVal >= end.val) {
    end.next = new Node(insertVal, end.next);
  } else {
    console.log("x");
    while (start.next.val < insertVal) {
      start = start.next;
    }
    start.next = new Node(insertVal, start.next);
  }

  return head;
};
