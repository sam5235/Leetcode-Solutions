class Solution {
    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();
        String lowS = s.toLowerCase();
        String highS = s.toUpperCase();
        for(int i = 0; i < s.length(); i++){
            if(!st.isEmpty() && (st.peek() == lowS.charAt(i) || st.peek() == highS.charAt(i)) && st.peek() != s.charAt(i))
                st.pop();
            else  st.push(s.charAt(i));
        }
        StringBuilder ans = new StringBuilder();
        for(char c : st)
            ans.append(c);
        return ans.toString();
    }
}