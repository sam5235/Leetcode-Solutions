class Solution {
    public int maxChunksToSorted(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int max = 0;
        for(int i = 0; i < arr.length; i++){
            if(st.isEmpty() || st.peek() <= arr[i])
                st.push(arr[i]);
            else {
                while(!st.isEmpty() && st.peek() > arr[i]){
                    max = Math.max(max, st.pop());
                
                }
                st.push(max);
                
            }
        }
        return st.size();
    }
}