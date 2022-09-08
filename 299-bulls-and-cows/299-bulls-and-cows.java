class Solution {
    public String getHint(String secret, String guess) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = secret.length();
        int bulls = 0;
        int cows = 0;
        
        for(int i = 0; i < n; i++){
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if(s == g){
                bulls++;
            }else{
                int freq = map.getOrDefault(s, 0) + 1;
                map.put(s, freq);
            }
        }
        
        for(int i = 0; i < n; i++){
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            
            if(s != g){
                if(map.containsKey(g) && map.get(g) > 0){
                    map.put(g, map.get(g) - 1);
                    cows++;
                }
            }
        }
        return bulls + "A" + cows + "B";
    }
}