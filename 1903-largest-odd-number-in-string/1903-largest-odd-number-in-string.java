class Solution {
    public String largestOddNumber(String num) {
      for(int e=num.length()-1; e>=0; e--){
        if((num.charAt(e)-'0')%2!=0){
          return num.substring(0,e+1);
        }
      }
      return "";
    }
}