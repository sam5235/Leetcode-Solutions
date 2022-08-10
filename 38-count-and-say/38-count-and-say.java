class Solution {
    public String countAndSay(int n) {
       List<String> str = new ArrayList<>();
        str.add("1");
        str = counter(n, str);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.size(); i++){
            sb.append(str.get(i));
        }
        return sb.toString();
    }
 List<String> counter(int n, List<String> str){
     if(n == 1) return str;
     int i = 0;
     int c = 1;
     List<String> nwStr = new ArrayList<>();
     while(i < str.size()){
         if(i < str.size() - 1 && str.get(i).equals(str.get(i + 1))) c++;
         else  {
             nwStr.add(c + "");
             nwStr.add(str.get(i));
             c = 1;
         }
        
         i++;
         }
     
     return counter(n - 1, nwStr);
 }   
}