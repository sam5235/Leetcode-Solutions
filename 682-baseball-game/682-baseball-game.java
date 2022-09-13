class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> st = new Stack<>();
        
        for(String s : ops){
            if(s.equals("D")){
                st.push(st.peek() * 2);
            }else if(s.equals("C")){
                st.pop();
            }else if(s.equals("+")){
                int temp = st.pop();
                int temp2 = st.peek() + temp;
                st.push(temp);
                st.push(temp2);
            }else{
                st.push(Integer.parseInt(s));
            }
        }
        int sum = 0;
        while(!st.isEmpty()) sum += st.pop();
    return sum;
    }
}