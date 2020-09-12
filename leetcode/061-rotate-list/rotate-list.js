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
  if (head === null || head.next === null) {
    return head;
  }

  let len = 1; // we won't iterate over last.next, so starting with +1
  let node = head;
  while (node.next) {
    len++;
    node = node.next;
  }

  let end = node;

  // looping the ll
  end.next = head;

  // we need to cut-off 1 node before, that's why -1
  node = head;
  for (let i = 0; i < len - (k % len) - 1; i++) {
    node = node.next;
  }

  head = node.next;
  node.next = null;

  return head;
};
