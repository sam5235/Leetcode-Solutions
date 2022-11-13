class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();
        int[] min = {1,2,4,8,16,32};
        int[] hrs = {1,2,4,8};
        int bitH = 0;
        int bitM = turnedOn;
        
        while(bitM >= 0){
            List<String> minute = new ArrayList<>();
            List<String> hour = new ArrayList<>();
            dfs(min, bitM, 0, 0, minute, 59);
            dfs(hrs, bitH, 0, 0, hour, 11);
          

            for(String h : hour){
                for(String m : minute){
                    ans.add(h +":" + m);                    
                }
            }
            
            bitH++;
            bitM--;
        }
        return ans;
        
    }
    
    void dfs(int[] arr, int countB, int time, int idx, List<String> ls, int limit){
        if(countB == 0 && time <= limit){
            ls.add(limit == 59 ?pad(time) : time + "");
            return;
        }
        if(time > limit || idx >= arr.length)
            return;
        
        dfs(arr, countB - 1, time + arr[idx], idx + 1, ls, limit);
        dfs(arr, countB, time, idx + 1, ls, limit);
    }
    
    String pad(int time){
        return time <= 9 ?"0" +time : time + ""; 
    }
        
}
