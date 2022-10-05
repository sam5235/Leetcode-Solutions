class Solution {
    public String minWindow(String s, String t) {
        List<List<Integer>> ls = new ArrayList<>();
        int[] chars = new int[52];
        for(int i = 0; i < t.length(); i++){
            if(t.charAt(i) - 'a' < 0){
                chars[t.charAt(i) - 'A']++;
            }else{
                chars[(int)t.charAt(i) - 71]++;
            }
        }
        int[] chars2 = new int[52];
        int i = 0, j = 0;
        int min = s.length() + 1;
        int start = 0, end = 0;
        while(j < s.length()){
            if(isEqual(chars, chars2)){
                min = Math.min(min, (j - i));
                if(min == (j - i)){
                    start = i; 
                    end = j - 1;
                }
                char c = s.charAt(i);
                int idx = c - 'a' < 0 ? c - 'A' : (int)c - 71;
                chars2[idx]--;
                i++;
            }else{
                char c = s.charAt(j);
                int idx = c - 'a' < 0 ? c - 'A' : (int)c - 71;
                chars2[idx]++;
                j++;
            }
          }
         j--;
         while(isEqual(chars, chars2)){
                min = Math.min(min, (j - i + 1));
                if(min == (j - i + 1)){
                    start = i; 
                    end = j;
                }
             char c = s.charAt(i);
             int idx = c - 'a' < 0 ? c - 'A' : (int)c - 71;
             chars2[idx]--;
             i++;
         }
        
        return min == s.length() + 1 ? "" : s.substring(start,end + 1);
    }
    boolean isEqual(int[] c1, int[]c2){
        for(int i = 0; i < 52; i++){
            if(c1[i] > c2[i]) return false;
        }
        return true;
    }
}