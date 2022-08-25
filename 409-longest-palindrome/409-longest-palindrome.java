class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        List<Character> chars = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            int freq = map.getOrDefault(s.charAt(i), 0) + 1;
            if(freq == 1) chars.add(s.charAt(i));
            map.put(s.charAt(i), freq);
        }
       
        
        int max = 0;
        int wait = 0;
        for(int i = 0; i < chars.size(); i++){
            if(map.get(chars.get(i)) >= 2){
                max += map.get(chars.get(i)) - (map.get(chars.get(i)) % 2);
                wait = Math.max(wait,map.get(chars.get(i)) % 2);
            }
            if(map.get(chars.get(i)) == 1) wait = 1;
        }
        return max + wait;
    }
}