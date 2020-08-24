/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */

var mergeTwoLists = function (list1, list2) {
  let node = new ListNode(0);
  const result = node;

  while (list1 && list2) {
    if (list1.val < list2.val) {
      node.next = new ListNode(list1.val, list1.next);
      list1 = list1.next;
      node = node.next;
    } else {
      node.next = new ListNode(list2.val, list2.next);
      list2 = list2.next;
      node = node.next;
    }
  }

  while (list1) {
    node.next = new ListNode(list1.val, list1.next);
    node = node.next;
    list1 = list1.next;
  }

  while (list2) {
    node.next = new ListNode(list2.val, list2.next);
    node = node.next;
    list2 = list2.next;
  }

  return result.next;
}

/**
 * @param {ListNode[]} lists
 * @return {ListNode}
 */
var mergeKLists = function(lists) {
  let result = null;
  for (let i = 0; i < lists.length; i++) {
    result = mergeTwoLists(result, lists[i]);
  }
  return result;
};
