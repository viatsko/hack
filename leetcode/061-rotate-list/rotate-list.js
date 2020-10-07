/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode}
 */
const rotateRight = function (head, k) {
  if (head === null) {
    return null;
  }

  let len = 0;
  let end = null;
  let node = head;
  while (node) {
    end = node;
    len++;
    node = node.next;
  }

  end.next = head;
  node = head;
  for (let i = 0; i < len - (k % len) - 1; i++) {
    node = node.next;
  }

  head = node.next;
  node.next = null;

  return head;
};
