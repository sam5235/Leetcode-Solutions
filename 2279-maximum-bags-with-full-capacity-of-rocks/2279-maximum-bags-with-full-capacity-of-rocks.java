class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] diff = new int[rocks.length];
        for(int i = 0; i < rocks.length; i++){
            diff[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(diff);
        int ans = 0;
        for(int num : diff){
            if(num == 0)
                ans++;
            else{
                if(num <= additionalRocks){
                    additionalRocks -= num;
                    ans++;
                }else return ans;
            }
        }
        return ans;
    }
}