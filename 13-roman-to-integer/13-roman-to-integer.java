class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int ans = 0;
        Stack<Integer> st = new Stack<>();
    
        for(int i = 0; i < s.length(); i++){
            if(st.isEmpty()) st.push(map.get(s.charAt(i)));
            else{
                if(st.peek() < map.get(s.charAt(i))){
                    st.push(map.get(s.charAt(i)) - st.pop());
                }else st.push(map.get(s.charAt(i)));
            }
        }
        while(!st.isEmpty()) ans += st.pop();
        return ans;
        
    }
}