# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
      
      def merge_lists(prev_node, node_1, node_2):
        if (node_1 and not node_2) or (node_1 and node_1.val <= node_2.val):
          prev_node.next = node_1
          merge_lists(node_1, node_1.next, node_2)
        elif node_2:
          prev_node.next = node_2
          merge_lists(node_2, node_1, node_2.next)
      
      initial_node = ListNode()
      prev_node = initial_node
      
      merge_lists(prev_node, list1, list2)
      return initial_node.next
        