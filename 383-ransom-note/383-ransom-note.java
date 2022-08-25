class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for(int i =  0; i < magazine.length(); i++){
            int freq = map1.getOrDefault(magazine.charAt(i) - 'a', 0) + 1;
            map1.put(magazine.charAt(i) - 'a', freq);
        }
        
        for(int i =  0; i < ransomNote.length(); i++){
             int freq = map2.getOrDefault(ransomNote.charAt(i) - 'a', 0) + 1;
             map2.put(ransomNote.charAt(i) - 'a', freq);
        }
        for(int i = 0; i < 26; i++){
            if(map2.containsKey(i) && map1.containsKey(i)){
                if(map2.get(i) > map1.get(i)) return false;
            }
            if(map2.containsKey(i) && !map1.containsKey(i)) return false;
        }
        return true;
    }
}