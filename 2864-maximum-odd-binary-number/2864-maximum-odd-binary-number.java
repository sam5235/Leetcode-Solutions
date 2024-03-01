class Solution {
    public String maximumOddBinaryNumber(String s) {
      int ones = 0;
      StringBuilder sb = new StringBuilder();
      for(char bit: s.toCharArray()){
        if(bit =='1')
          ones++;
      }
      for(int i=0; i<s.length()-1; i++){
        if(ones > 1){
          sb.append("1");
          ones--;
        }else sb.append("0");        
      }
      sb.append("1");
        return sb.toString();
    }
}

