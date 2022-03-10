class Solution {
    public String removeDuplicateLetters(String s) {
        char[] ch = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : ch){
            int freq = map.getOrDefault(c , 0) + 1;
            map.put(c, freq);
        }
        Stack<Character> st = new Stack<>();
        HashSet<Character> set = new HashSet<>();
        st.push(ch[0]);
        set.add(ch[0]);
        for(int i = 1; i < ch.length; i++){
            while(!st.isEmpty() && ch[i] < st.peek() && !set.contains(ch[i]) && map.get(st.peek()) > 1){
                map.put(st.peek(), map.get(st.peek()) -1);
                set.remove(st.pop());
               
            }
            if(!set.contains(ch[i])){
                st.push(ch[i]);
                set.add(ch[i]);
                
            }else map.put(ch[i], map.get(ch[i]) -1);
            
            
        }
        StringBuilder sb = new StringBuilder();  
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        return sb.toString();
    
 }
}