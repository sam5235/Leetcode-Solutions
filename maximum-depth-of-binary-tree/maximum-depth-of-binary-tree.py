# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:

      def max_depth(node):
        if not node:
          return 0
        return max(max_depth(node.left), max_depth(node.right)) + 1
      return max_depth(root)
        
        