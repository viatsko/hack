/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} headA
 * @param {ListNode} headB
 * @return {ListNode}
 */
const getIntersectionNode = function (headA, headB) {
  let first = headA;
  let second = headB;

  while (first !== second) {
    first = first ? first.next : headB;
    second = second ? second.next : headA;
  }

  return first;
};
