/**
 * // Definition for a Node.
 * function Node(val, next, random) {
 *    this.val = val;
 *    this.next = next;
 *    this.random = random;
 * };
 */

/**
 * @param {Node} head
 * @return {Node}
 */
const copyRandomList = function (head) {
  const clonedHead = getOrCreate(head);

  let node = head;
  while (node) {
    const clonedNode = getOrCreate(node);
    clonedNode.next = getOrCreate(node.next);
    clonedNode.random = getOrCreate(node.random);
    node = node.next;
  }

  return clonedHead;
};

const map = new Map();
const getOrCreate = function (node) {
  if (!node) {
    return null;
  }

  if (map.has(node)) {
    return map.get(node);
  } else {
    map.set(node, new Node(node.val));
    return map.get(node);
  }
};
