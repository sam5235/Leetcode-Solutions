class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            int start = merged.get(merged.size() - 1)[0];
            int end = merged.get(merged.size() - 1)[1];
            if(end>= intervals[i][0]&&end<intervals[i][1])
                merged.set(merged.size()-1, new int[]{start, intervals[i][1]});
            else if(end<intervals[i][0])
                merged.add(intervals[i]);
        }
        int[][] ans = new int[merged.size()][2];
        int i = 0;
        for(int[] merg: merged){
            ans[i] = merg;
            i++;
        }
      return ans;
    }
} 

