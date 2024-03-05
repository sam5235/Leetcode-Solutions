class Solution {
    public int minimumLength(String s) {
      int i=0, j=s.length()-1;
      char letter= s.charAt(i)==s.charAt(j)? s.charAt(i): 'z';
      while(i<j){
        if(letter != s.charAt(i) && letter != s.charAt(j))
          break;
        if(letter==s.charAt(j)){
          j--;
        }
        if(s.charAt(i)==letter){
          i++;
        }
        if(i<j && s.charAt(i)==s.charAt(j))
          letter=s.charAt(i);
      }
      if(i==j&&letter==s.charAt(i)&&s.length()>1)
        return 0;

      return j-i+1;
    }
}

/*

*/