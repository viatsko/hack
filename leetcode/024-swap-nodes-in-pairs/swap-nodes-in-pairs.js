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
const swapPairs = function (head) {
  if (!head || !head.next) {
    return head;
  }

  const first = head;
  const second = head.next;

  first.next = swapPairs(second.next);
  second.next = first;

  return second;
};
