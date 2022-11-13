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
            dfsM(min, bitM, 0, 0, minute);
            dfsH(hrs, bitH, 0, 0, hour);
          

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
    
    void dfsM(int[] min, int countB, int time, int idx, List<String> ls){
        if(countB == 0 && time <= 59){
            ls.add(pad(time));
            return;
        }
        if(time > 59 || idx >= min.length)
            return;
        
        dfsM(min, countB - 1, time + min[idx], idx + 1, ls);
        dfsM(min, countB, time, idx + 1, ls);
    }
    
    void dfsH(int[] hrs, int countB, int time, int idx, List<String> ls){
        if(countB == 0 && time <= 11){
            ls.add(time +"");
            return;
        }
        if(time > 11 || idx >= hrs.length)
            return;
        
        dfsH(hrs, countB - 1, time + hrs[idx], idx + 1, ls);
        dfsH(hrs, countB, time, idx + 1, ls);
    }
    String pad(int time){
        return time <= 9 ?"0" +time : time + ""; 
    }
        
}
