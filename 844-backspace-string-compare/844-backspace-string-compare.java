class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        
       s = clearBack(new StringBuilder(), s);
       t = clearBack(new StringBuilder(), t);
        
        return s.equals(t);
        
        
    }
    
        String clearBack(StringBuilder sb, String s){
            int i = 0;
            while(i < s.length()){
            if(s.charAt(i) == '#'){
                if(sb.length() > 0){
                        sb.deleteCharAt(sb.length()-1); 
                    }
                }
                else sb.append(s.charAt(i));
                i++;
                
            }
            return sb.toString();
        }
}