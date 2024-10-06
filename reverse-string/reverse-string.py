class Solution:
    def reverseString(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        def reverse_string(st, en):
          if st >= en:
            return
          reverse_string(st + 1, en - 1)
          s[st], s[en] = s[en], s[st]
       
        reverse_string(0, len(s) - 1)          