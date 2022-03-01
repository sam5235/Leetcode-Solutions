class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int min = 0;
        int max = 0;
        for(int num : weights){
            max += num;
            min = Math.max(min, num);
        }
        int low = min;
        int high = max;
        int ans = max;
        while(low <= high){
            int mid = low + (high - low)/2;
            int day = days(weights, mid);
            if(day > days){
                low = mid + 1;
            }else{
                ans = Math.min(ans, mid);
                high = mid - 1;
            }
        }
        return ans;
    }
    public int days(int[] weights, int capacity){
        int count = 0;
        int sum = 0;
        for(int i = 0; i < weights.length; i++){
            sum += weights[i];
            if(sum > capacity){
                   count++;
                   i--;
                   sum = 0;
            }
        }
        return count + 1;
    }
}
//
