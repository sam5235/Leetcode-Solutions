class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> place = new HashMap<>();
        int i = 0, j = 0, ans = 0;
        
        while(j<s.length()){
            if(!place.containsKey(s.charAt(j))){
                place.put(s.charAt(j), j);
                ans = Math.max(ans, j-i+1);
                j++;
            }else{
                // ans = Math.max(ans, j-i+1);
                int idx = place.get(s.charAt(j));
                while(i<=idx){
                    place.remove(s.charAt(i));
                    i++;
                }
            }
        }
        return ans;
    }
}


/*
  pwwkew12
  - storing a character with it's index
  - using two pointers searching for the not repeating substring

*/