class Solution {
    public String[] findRelativeRanks(int[] score) {
        
  PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        for(int i = 0; i < score.length; i++){
            pq.add(new int[]{i, score[i]});
        }
     
        String[] str = new String[score.length];
       
        if(!pq.isEmpty()) str[pq.poll()[0]] = "Gold Medal";
           if(!pq.isEmpty()) str[pq.poll()[0]] = "Silver Medal";
          if(!pq.isEmpty())  str[pq.poll()[0]] = "Bronze Medal";
    
        int i = 4;
        while(i <= score.length && !pq.isEmpty()){
            str[pq.poll()[0]] = i + "";
            i++;
        }
       return str;
    }
}