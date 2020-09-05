# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def oddEvenList(self, head: ListNode) -> ListNode:
        oddHead = head

        if head != None:
            evenHead = head.next

            odd = oddHead
            even = evenHead

            while even != None and even.next != None:
                odd.next = odd.next.next
                odd = odd.next
                even.next = even.next.next
                even = even.next

            odd.next = evenHead

        return oddHead