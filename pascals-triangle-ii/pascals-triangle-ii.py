class Solution:
    def getRow(self, rowIndex: int) -> List[int]:
      self.paskal_vals = defaultdict()
      answer = list()
      for i in range(rowIndex  + 1):
        answer.append(self.getCell(rowIndex, i, rowIndex + 1))
      return answer
    
    def getCell(self, r, c, m):
      if r == 0 or c == 0 or c == m - 1:
        return 1
      if (r,c) in self.paskal_vals:
        return self.paskal_vals[(r,c)]
      self.paskal_vals[(r,c)] = self.getCell(r - 1, c - 1, r) + self.getCell(r - 1, c, r)
      return self.paskal_vals[(r,c)]
        
      
      