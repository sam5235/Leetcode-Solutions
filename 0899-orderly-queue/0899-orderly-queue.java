class Solution {
    public String orderlyQueue(String s, int k) {
        String ans = s;
        if(k == 1){
            for(int i = 0; i < s.length(); i++){
                StringBuilder sb = new StringBuilder(s.substring(1, s.length()));
                sb.append(s.charAt(0));
                if(!compare(ans, sb.toString()))
                    ans = sb.toString();
                s = sb.toString();
            }
        }else{
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            ans = new String(chars);
        }
            
        
        return ans;
    }
    boolean compare(String init, String newS){
        return init.compareTo(newS) < 0;
        
    }
}