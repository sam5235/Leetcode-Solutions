# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
      if not head:
        return None
      if not head.next:
        return head
      nxt = head.next.next
      head.next.next = head
      head = head.next
      head.next.next = self.swapPairs(nxt)
      return head
        