class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int i = 0;
        int pop;
        int j = 0;
        while(j < popped.length){
            pop = popped[j];
            if(i < pushed.length && pop == pushed[i]){
                i++;
                j++;
            }else if(!st.empty() && pop == st.peek()){
                st.pop();
                j++;
            }else if(i < pushed.length ){
                    st.push(pushed[i]);
                i++;
            }else return false;
        }
        return (i == pushed.length && st.isEmpty());
//         int i = 0;
//         while(j < popped.length){
//             if(i < pushed.length){
//                 while(i < pushed.length && (popped[j] != pushed[i] && (!st.empty() && popped[j] != st.peek()))){
//                     System.out.println(i + " " + j);
//                     st.push(pushed[i]);
                    
//                   i++;
//                 }
//                 while(i < pushed.length && j < popped.length && (popped[j] == pushed[i])){
//                   i++;
//                   j++;
//                 }
//             }
           
//             while(!st.isEmpty() && popped[j] == st.peek()){
//                 st.pop();
                
//             }
//             j++;
//         }
//         System.out.println(st +" "+i+" " + j);
//         return (i == pushed.length && st.isEmpty());
        
    }
}