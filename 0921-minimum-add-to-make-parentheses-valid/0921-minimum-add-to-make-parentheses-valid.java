class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') st.add(s.charAt(i));
            else{
                if(!st.isEmpty() && st.peek() == '(') st.pop(); 
                else st.add(s.charAt(i));
            }
        }
        return st.size();
    }
}