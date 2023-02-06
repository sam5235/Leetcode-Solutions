class Solution {
    public int prefixCount(String[] words, String pref) {
        int count = 0;
      for(int i = 0; i < words.length; i++){
          StringBuilder sb = new StringBuilder();
          for(int s = 0; s < words[i].length(); s++){
              sb.append(words[i].charAt(s));
              if(ispref(sb.toString(), pref))
                  count++;
          }
      }
      return  count;
    } 
    
    boolean ispref(String str, String pref){
        return str.equals(pref);
    }
}