class Solution {
    public boolean isAnagram(String s, String t) {
        if(t.length() != s.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            int freq = map.getOrDefault(c, 0) + 1;
            map.put(c, freq);
        }
        for(int i = 0; i < t.length(); i++){
            if(map.containsKey(t.charAt(i)) && map.get(t.charAt(i)) > 0){
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
            }else return false;
        }
        
        return true;
    }
}