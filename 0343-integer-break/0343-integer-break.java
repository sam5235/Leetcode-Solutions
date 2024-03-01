class Solution {
    public int integerBreak(int n) {
        int[] memo = new int[n+1];
        if(n == 2)
          return 1;
        if(n==3)
          return 2;        
        return  helper(n, memo);
    }
  
  int helper(int k, int[] memo){
      if(k==1)
        return 1; 
      if(k == 2)
        return 2;
      if(k == 3)
        return 3;
      if(memo[k] != 0)
        return memo[k];
      memo[k] = Math.max(2 *helper(k-2, memo), 3 *helper(k-3, memo));
   return memo[k];    
  }
}

/*
n=8
1,2,4,6,9,12,18,
4 4 
3 3 2 = 18
5
2 3 = 6
6
3 3 = 9
7
4 3 = 12
8
4 4 = 16
1 7 = 1 *2 * 2 * 3 = 
7
3 4
---------------
10

2 8
 
 8

2 6

6  

2 4   3 3 

4

2 2

*/