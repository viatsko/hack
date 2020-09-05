/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {boolean}
 */
var isPalindrome = function (head) {
  let slow = head;
  let fast = head;

  while (fast && fast.next) {
    slow = slow.next;
    fast = fast.next.next;
  }

  let reversed = reverseList(slow);
  while (head && reversed) {
    if (head.val !== reversed.val) {
      return false;
    }

    head = head.next;
    reversed = reversed.next;
  }

  return true;
};

var reverseList = function (head) {
  let newHead = null;

  while (head) {
    const next = head.next;
    head.next = newHead;
    newHead = head;
    head = next;
  }

  return newHead;
};
