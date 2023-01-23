class Solution {
    public int findJudge(int n, int[][] trust) {
         List<Integer>[] likes = new ArrayList[n + 1];
         for(int i = 0; i < n + 1; i++)
             likes[i] = new ArrayList<>();
         boolean[] notJudge = new boolean[n + 1];
         for(int i = 0; i < trust.length; i++){
             likes[trust[i][1]].add(trust[i][0]);
             notJudge[trust[i][0]] = true;
         }
         for(int i = 1; i <= n; i++){
            if(likes[i].size() == n - 1 && !notJudge[i])
                return i;
         }
         return -1;
    }
}