class Solution:
    @cache
    def myPow(self, x: float, n: int) -> float:
      if n == 0:
        return 1
      if n == 1:
        return x
      if n == -1:
        return 1/x
      if n%2 != 0:
        return self.myPow(x, n//2) * self.myPow(x, n//2) * x
      return self.myPow(x, n//2) * self.myPow(x, n//2)
