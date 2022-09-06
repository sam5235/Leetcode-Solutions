class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if(p.length() > s.length()) return ans;
        int[] pArr = new int[26];
        int[] sArr = new int[26];
        
        for(int i = 0; i < p.length(); i++){
            pArr[p.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < p.length(); i++){
            sArr[s.charAt(i) - 'a']++;
        }
        
        int i = 0;
        int j = p.length() - 1;
        
        while(j < s.length()){
            if(check(pArr, sArr)){
                ans.add(i);
            }
            
            sArr[s.charAt(i) - 'a']--;
            i++;
            j++;
            if(j < s.length()){
                sArr[s.charAt(j) - 'a']++;
            }
        }
        return ans;        
    }
    
    boolean check(int[] arr1 , int[] arr2){
        for(int i = 0; i < 26; i++){
                if(arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}