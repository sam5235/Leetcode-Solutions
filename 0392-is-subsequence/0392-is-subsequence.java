class Solution {
    public boolean isSubsequence(String s, String t) {
        int[][] grid = new int[s.length()][t.length()];
        if(s.length() == 0)
            return true;
        if(t.length() == 0)
            return false;
        for(int i = 0; i < t.length() && s.length() > 0; i++){
             char c1 = s.charAt(0);
             char c2 = t.charAt(i);
            if(c1 == c2)
                grid[0][i] = 1;
            else grid[0][i] = i > 0 ? grid[0][i - 1] : 0;
        }
             
        for(int i = 1; i < grid.length; i++){
            for(int j = 1; j < grid[0].length; j++){
                if(s.charAt(i) == t.charAt(j))
                   grid[i][j] = grid[i - 1][j -1];
                else  grid[i][j] = grid[i][j -1];

            }
        }
        return grid[s.length() - 1][t.length() - 1] == 1;
    }
}