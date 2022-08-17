class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> b[0] - a[0]);
        int[] chars = new int[26];
        for(char c : s.toCharArray()) chars[c - 'a']++;  
     
        for(int i = 0; i < 26; i++){
            if(chars[i] != 0){
                pq.add(new int[]{i, chars[i]});
                
            } 
        }
        

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            int[] polled = pq.poll();
            
            if(polled[1] > repeatLimit){
                for(int i = 0; i < repeatLimit; i++)sb.append((char)(polled[0] + 'a'));
                polled[1] = polled[1] - repeatLimit;
               
                if(!pq.isEmpty()){
                    int[] peeked = pq.peek();
                    sb.append((char)(peeked[0] + 'a'));
                    peeked[1]--;
                    if(peeked[1] <= 0) pq.poll();
                }else return sb.toString();
            }else {
                for(int i = 0; i < polled[1]; i++) sb.append((char)(polled[0] + 'a'));
                polled[1] = 0;
            }
                if(polled[1] > 0) pq.add(polled);
        }
        return sb.toString();
        
    }
}