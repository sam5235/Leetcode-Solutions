class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        map.put(s.charAt(0), t.charAt(0));
        set.add(t.charAt(0));
        for(int i = 0; i < s.length(); i++){
            if(!map.containsKey(s.charAt(i)) && !set.contains(t.charAt(i))){
                map.put(s.charAt(i), t.charAt(i));
                set.add(t.charAt(i));
            }
            else  if(!map.containsKey(s.charAt(i)) && set.contains(t.charAt(i))) return false;
            else if(map.get(s.charAt(i)) != t.charAt(i)) return false;
        }
        return true;
    }
}