class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        
        for(String s : banned){
            set.add(s);
        }        
          
        StringBuilder sb = new StringBuilder();
        for(char c: paragraph.toCharArray()){
                if((int) c >= 65 ){
                    sb.append(c);
                }
            else{
                    
                   if(!set.contains(sb.toString().toLowerCase()) && sb.length() > 0){

                            int freq = map.getOrDefault(sb.toString().toLowerCase(), 0) + 1;
                            map.put(sb.toString().toLowerCase(), freq);

                    }
                       sb = new StringBuilder();
                }
            } 
          if(!set.contains(sb.toString().toLowerCase()) && sb.length() > 0){

                            int freq = map.getOrDefault(sb.toString().toLowerCase(), 0) + 1;
                            map.put(sb.toString().toLowerCase(), freq);

                    }

        String ans = "";
        int max = 0;
        for(String key : map.keySet()){
            max = Math.max(max, map.get(key));
            if(max == map.get(key)) ans = key;
        }
        
        return ans;
    }
}