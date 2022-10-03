class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int i = 0, j = 0, sum = 0, n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(j < firstLen){
           sum += nums[j];
            j++;
        }
        map.put(0, sum);
        while(j < n){
            sum += nums[j];
            sum -= nums[i];
            i++;
            j++;
            map.put(i, sum);
        }
        int max = 0;
        sum = 0;
        i = 0;
        j = 0;
        while(j < secondLen){
           sum += nums[j];
            j++;
        }j--;
        while(j < n){
           for(int key : map.keySet()){
               if(key > j || i > (key + firstLen - 1)){
                   max = Math.max(max, (sum + map.get(key)));
               }
           }
           sum -= nums[i];
            i++;
            j++;
           if(j < n)sum += nums[j]; 
        }
        return max;
    }
}
