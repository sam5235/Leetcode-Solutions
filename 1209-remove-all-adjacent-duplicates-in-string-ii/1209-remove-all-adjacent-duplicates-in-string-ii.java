class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair<Character, Integer>> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(!st.isEmpty()&&st.peek().getKey()==s.charAt(i)){
                st.push(new Pair<>(st.peek().getKey(), st.pop().getValue()+1));                
            }
            else st.push(new Pair<>(s.charAt(i),1));
            if(st.peek().getValue()==k)
                st.pop();
        }
        StringBuilder answer = new StringBuilder();
        while(!st.isEmpty()){
            for(int i=0; i<st.peek().getValue(); i++){
                answer.append(st.peek().getKey());
            }
            st.pop();
        }
        return answer.reverse().toString();
    }
}
