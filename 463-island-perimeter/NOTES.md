```
int[] peri = new int[1];
HashSet<List<Integer>> visited = new HashSet<>();
int i = 0;
while( i < grid.length){
int j = 0;
while( j < grid[0].length){
if(grid[i][j] == 1) {
visited.add(new ArrayList<>(Arrays.asList(i,j)));
dfs(grid, j, i, peri, visited);
return peri[0];
}
j++;
}
i++;
}
return 0;
}
void dfs(int[][] grid, int col, int row, int[] peri, HashSet<List<Integer>> visited){
int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
for(int i = 0; i < 4; i++){
int newRow = row + dir[i][0];
int newCol = col + dir[i][1];
if(outOfBound(newCol, newRow,  grid[0].length, grid.length) || grid[newRow][newCol] == 0 ){
peri[0]++;
}else{
if(!visited.contains(new ArrayList<>(Arrays.asList(newRow, newCol)))){
visited.add(new ArrayList<>(Arrays.asList(newRow, newCol)));
dfs(grid, newCol, newRow, peri, visited);
}
}
}
}
boolean outOfBound(int c, int r, int n, int m){
return (c >= n || c < 0 || r >= m || r < 0 );
}
```