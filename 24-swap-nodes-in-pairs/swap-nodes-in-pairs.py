# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(0, head)

        prev, cur = dummy, head

        while cur and cur.next:
            # save pointers
            nextPair = cur.next.next
            second = cur.next

            # reverse this pair
            second.next = cur
            prev.next = second
            cur.next = nextPair

            # update pointers
            prev = cur
            cur = nextPair

        return dummy.next

