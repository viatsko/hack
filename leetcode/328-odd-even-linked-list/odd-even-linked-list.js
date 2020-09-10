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
const oddEvenList = function (head) {
  const oddHead = head;

  if (!head) {
    return null;
  }

  const evenHead = head.next;

  let oddP = oddHead;
  let evenP = evenHead;

  while (oddP.next && evenP.next) {
    const oddNext = oddP.next.next;
    const evenNext = evenP.next.next;
    oddP.next = oddNext;
    evenP.next = evenNext;
    oddP = oddP.next;
    evenP = evenP.next;
  }

  oddP.next = evenHead;

  return oddHead;
};
