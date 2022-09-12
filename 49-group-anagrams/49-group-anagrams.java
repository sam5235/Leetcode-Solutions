class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ls = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        
        for(int i = 0; i < strs.length; i++){
            String s = converter(strs[i]);
            List<String> newLs = map.getOrDefault(s, new ArrayList<>());
            newLs.add(strs[i]);
            map.put(s, newLs);
        }
        
        for(String key : map.keySet()){
            ls.add(map.get(key));
        }
        
        return ls;
    }
    String converter(String str){
        int[] chars = new int[26];
        
        for(char c : str.toCharArray()){
            chars[c - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < chars.length; i++){
            sb.append(chars[i] + ",");
        }
        
        return sb.toString();
    }
}