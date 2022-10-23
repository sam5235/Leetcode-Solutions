class Solution {
    public int balancedStringSplit(String s) {
        Stack<Character> st = new Stack<>();
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(!st.isEmpty() && st.peek() != s.charAt(i)){
                st.pop();
            }else st.push(s.charAt(i));
            
            if(st.isEmpty()){
                count++;
            }
            
        }
        return count;
    }
}