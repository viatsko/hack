/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var reverseList = function (node) {
  if (!node || !node.next) {
    return node;
  }

  const next = reverseList(node.next);
  node.next.next = node;
  node.next = null;
  return next;
};
