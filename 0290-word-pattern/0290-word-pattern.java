class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Character> map2 = new HashMap<>();

        String[] words = s.split(" ");
        if(pattern.length() != words.length)
            return false;
        for(int i = 0; i < pattern.length(); i++){
            if((map.containsKey(pattern.charAt(i)) && !words[i].equals(map.get(pattern.charAt(i)))) || (map2.containsKey(words[i]) && pattern.charAt(i)!=(map2.get(words[i])))){
                return false;
            } else {
                map.put(pattern.charAt(i), words[i]);
                map2.put(words[i], pattern.charAt(i));
            }
        }
        return true;
    }
}