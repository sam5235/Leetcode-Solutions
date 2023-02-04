class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] letters = new int[26];
        for(int i = 0; i < s1.length(); i++){
            letters[s1.charAt(i) - 'a']++;
        }
        if(s2.length() < s1.length())
            return false;
        int[] check = new int[26];
        for(int i = 0; i < s1.length(); i++){
            check[s2.charAt(i) - 'a']++;
        }
        if(perm(letters).equals(perm(check)))
            return true;
        

        int i = 0;
        int j = s1.length() - 1;
        while(j < s2.length() && i < s2.length()){
               check[s2.charAt(i) - 'a']--;
               i++;
               j++;
               if(j < s2.length())
                    check[s2.charAt(j) - 'a']++;

               if(perm(letters).equals(perm(check)))
                    return true;
           }
          
        
        return false;
    }
    
    String perm(int[] st){
        StringBuilder sb = new StringBuilder();
        for(int n: st)
            sb.append(n);
        return sb.toString();
    }
}