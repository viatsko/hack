/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} val
 * @return {ListNode}
 */
const removeElements = function (head, val) {
  while (head && head.val === val) {
    head = head.next;
  }
  let node = head;
  while (node) {
    while (node.next && node.next.val === val) {
      node.next = node.next.next;
    }
    node = node.next;
  }
  return head;
};
