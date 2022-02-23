class Solution {
    public int minStoneSum(int[] piles, int k) {
        Queue<Integer> q = new PriorityQueue<>((a,b)-> b - a);
        for(int num : piles){
            q.add(num);
        }
        for(int i = 0; i < k; i++){
           int temp = q.peek() -(q.poll()/2);
            q.add(temp);
        }
        int ans = 0;
      
        while(!q.isEmpty()){
            ans += q.poll();
        }
        return ans;
        
    }
}