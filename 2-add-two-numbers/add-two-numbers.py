# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode()
        dummy2 = dummy
        carry = 0
        while (l1 or l2 or carry):
            total = carry + (l1.val if l1 else 0) + (l2.val if l2 else 0)
            newVal = total % 10
            carry = total // 10
            dummy2.next = ListNode(newVal)
            l1 = l1.next if l1 else l1
            l2 = l2.next if l2 else l2

            dummy2 = dummy2.next

        return dummy.next
