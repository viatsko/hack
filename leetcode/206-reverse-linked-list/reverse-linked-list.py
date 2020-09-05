# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        newHead = None

        while head != None:
            next = head.next
            head.next = newHead
            newHead = head
            head = next

        return newHead