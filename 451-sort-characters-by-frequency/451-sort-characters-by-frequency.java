class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i =0; i < s.length(); i++){
            char c = s.charAt(i);
            int fq = map.getOrDefault(c, 0) + 1;
            map.put(c, fq);
        }
        Queue<Char> pq = new PriorityQueue<>((a,b)->b.freq - a.freq);
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            char key = entry.getKey();
            int val = entry.getValue();
            Char ch = new Char(val, key);
            pq.add(ch);
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Char temp = pq.poll();
            for(int i = 0; i < temp.freq; i++) sb.append(temp.c);
               
        }
        return sb.toString();
    }
     class Char{
         int freq;
         char c;
         public Char(int freq, char c){
             this.freq = freq;
             this.c = c;
         }
     } 
}

//5  : 44
//5: 48
//6 : 3