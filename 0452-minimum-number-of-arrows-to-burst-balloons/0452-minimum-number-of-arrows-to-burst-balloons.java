class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        Arrays.sort(points, (a,b) -> Integer.compare(a[1], b[1]));
        int i = 0, j = 1,arrows = 0;
        while(i < n && j < n){
            if(points[i][1] >= points[j][0]){
                j++;
            }else{
                arrows++;
                i = j++;
            }
        }
        
        return ++arrows;
    }
}