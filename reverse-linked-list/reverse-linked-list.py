# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
      
      def reverse_head(node, rev_head):
        if not node or not node.next:
          rev_head[0] = node
          return node
        reverse_head(node.next, rev_head).next = node
        if node == head:
          node.next = None
          return rev_head[0]
        return node
      
      node, rev_head = head, [head]
      return reverse_head(node, rev_head)