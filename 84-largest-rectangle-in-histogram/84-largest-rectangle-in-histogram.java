class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nextSmaller = new int[n];
        Arrays.fill(nextSmaller, n);
        
        int[] prevSmaller = new int[n];
        Arrays.fill(prevSmaller, -1);
        
        Stack<Integer> st = new Stack<Integer>();
        st.push(0);
        for(int i = 1; i < n; i++){
            while(!st.empty() && heights[i] < heights[st.peek()]){
                nextSmaller[st.pop()] = i;
            }
            st.push(i);
        }
       
        st.clear();
         st.push(n-1);
         for(int i = n-1; i >= 0; i--){
            while(!st.empty() && heights[i] < heights[st.peek()]){
                prevSmaller[st.pop()] = i;
            }
            st.push(i);
        }
        int max = 0;
        for(int i = 0; i < n; i++){
            max  = Math.max(max, (nextSmaller[i] - prevSmaller[i] -1) * heights[i]);
        }
        return max;
    }
}