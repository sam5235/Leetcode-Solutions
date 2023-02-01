class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        
        int[][] times = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            times[i][0] = plantTime[i];
            times[i][1] = growTime[i];
        }
        
        Arrays.sort(times, (a, b) -> b[1] - a[1]);
        
        int maxTime = 0;
        int currPlantTime = 0;
        
        for (int[] time : times) {
            currPlantTime += time[0];
            maxTime = Math.max(maxTime, currPlantTime + time[1]);
        }
        
        return maxTime;
    }
}