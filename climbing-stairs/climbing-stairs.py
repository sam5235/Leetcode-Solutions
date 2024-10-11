class Solution:
    @cache
    def climbStairs(self, n: int) -> int:
      if n == 1 or n == 2:
        return n
      return self.climbStairs(n - 1) + self.climbStairs(n - 2)
        