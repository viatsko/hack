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
var oddEvenList = function (head) {
  let oddHead = head;

  if (head) {
    let evenHead = head.next;

    let odd = oddHead;
    let even = evenHead;

    while (even && even.next) {
      odd.next = odd.next.next;
      odd = odd.next;

      even.next = even.next.next;
      even = even.next;
    }

    odd.next = evenHead;
  }

  return oddHead;
};
