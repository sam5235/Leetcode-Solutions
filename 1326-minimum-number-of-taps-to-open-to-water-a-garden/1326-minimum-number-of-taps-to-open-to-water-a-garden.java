class Solution {
    public int minTaps(int n, int[] ranges) {
       
        int[] furthestIdx = new int[n+1];
        Arrays.fill(furthestIdx, -1);
        
        for (int i = 0; i <= n; i++) {
            if (ranges[i] == 0) continue;
            
            int left = Math.max(i - ranges[i], 0);
            int right = Math.min(i + ranges[i], n);
            
            furthestIdx[left] = Math.max(furthestIdx[left], right);
        }
        
        int far = furthestIdx[0];  
        int t = 1;
        
        if (far == n) return 1;
        
        int next = 0;
        
        for (int i = 0; i <= n; i++) {
            if (i > far) return -1;
            
            next = Math.max(next, furthestIdx[i]);
            if (next == n) return t+1;
            
            if (i == far) {
                far = next;
                t++;
            }
        }
        
        return -1;
    }
}