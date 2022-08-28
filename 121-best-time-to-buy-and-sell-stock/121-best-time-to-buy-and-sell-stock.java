class Solution {
    public int maxProfit(int[] prices) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> b[0] - a[0]);
        for(int i = 0; i < prices.length; i++){
            pq.add(new int[]{prices[i], i});
        }
        int max = 0;
        for(int i = 0; i < prices.length; i++){
            if(i < pq.peek()[1] && prices[i] < pq.peek()[0]){
                int prof = pq.peek()[0] - prices[i];
                max = Math.max(max, prof);
            }
                while(!pq.isEmpty() && i >= pq.peek()[1]) pq.poll();
            
        }
        return max;
    }

}