class Solution {
    public int lengthOfLongestSubstring(String s) {
       HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int n = s.length();
        int max = 0;
        int length = 0;
        while(i < n && j < n){
            char c = s.charAt(j);
            if(!map.containsKey(c)){
                map.put(c, j);
                length++;
                j++;
            }
            else{
                map.remove(s.charAt(i));
                i++;
               length--;
                     
            }
                max = Math.max(max, length);
        }
         return max;
    }
}