class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int cnt = 0;
        for(int i = 0; i < costs.length; i++){
            coins -= costs[i];
            cnt++;
            if(coins == 0)
                return cnt;
            if(coins < 0)
                return (cnt - 1);
        }
        return cnt;
    }
}