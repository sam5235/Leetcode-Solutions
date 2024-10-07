# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:

      def reverse_head(node):
        if not node or not node.next:
          return node, node
        nxt, rev_head = reverse_head(node.next)
        nxt.next = node
        if node == head:
          node.next = None
        return node, rev_head
      
      node = head
      _, rev_head = reverse_head(node)
      return rev_head