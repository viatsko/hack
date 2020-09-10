/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
const addTwoNumbers = function (l1, l2) {
  const result = new ListNode(0);
  let node = result;

  let carry = 0;
  while (l1 || l2) {
    let a = l1 ? l1.val : 0;
    let b = l2 ? l2.val : 0;
    let val = a + b + carry;
    const cur = new ListNode(val % 10);
    carry = Math.floor(val / 10);
    node.next = cur;
    node = node.next;
    l1 && (l1 = l1.next);
    l2 && (l2 = l2.next);
  }

  if (carry) {
    node.next = new ListNode(carry);
  }

  return result.next;
};
