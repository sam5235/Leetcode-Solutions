class Solution {
    public int maxPoints(int[][] points) {
        int len = points.length, best = 0;
        HashMap<Double, Integer> lines = new HashMap<>();
        
        for(int idx = 0; idx < len; idx++){
            int[] pointA = points[idx];
            lines = new HashMap<>();
            int max = 1, verticalLinePts = 1;
            
            for(int itr = idx + 1; itr < len; itr++){
                int[] pointB = points[itr];  
                int changeY = pointB[1] - pointA[1];
                int changeX = pointB[0] - pointA[0];
                
                if(changeX == 0){
                    verticalLinePts++;
                }else{
                    double slope = changeY == 0 ? 0 : (double) changeY / (double) changeX;
                    int pts = lines.getOrDefault(slope, 1);
                    lines.put(slope, pts + 1);
                    max = Math.max(max, pts + 1);
                }
            }
            
            best = Math.max(best, Math.max(verticalLinePts, max));
        }
        
        return best;
    }
}