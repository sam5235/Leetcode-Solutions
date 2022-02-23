class Solution {
    public int minStoneSum(int[] piles, int k) {
        Queue<Integer> q = new PriorityQueue<>((a,b)-> b - a);
         int ans = 0;
        for(int num : piles){
            q.add(num);
            ans += num;
        }
        for(int i = 0; i < k; i++){
           int temp = q.peek() -(q.peek()/2);
            q.add(temp);
            ans -= q.poll()/2;
            
        }
       
      
      
        return ans;
        
    }
}