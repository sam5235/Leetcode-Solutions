class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<int[]> st = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            char curr = s.charAt(i);
            if(curr == '('){
                st.push(new int[]{0,i});
            }
            else if(curr == ')' && !st.isEmpty() && st.peek()[0] == 0){
             st.pop();   
            }else if(curr == ')') st.push(new int[]{1,i});
        }
        StringBuilder sb = new StringBuilder(s);
        while(!st.isEmpty()){
            sb.deleteCharAt(st.pop()[1]);
        }
        return sb.toString();
    }
}