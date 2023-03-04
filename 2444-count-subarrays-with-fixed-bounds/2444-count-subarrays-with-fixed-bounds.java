class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long count = 0;
        int n = nums.length;
        int[][] arr = new int[n + 1][3];
        arr[n][0] = n;
        arr[n][1] = n;
        arr[n][2] = n;
        for(int i = n - 1; i >= 0; i--){
            if(nums[i] < minK || nums[i] > maxK){
                arr[i][0] = i;
                arr[i][1] = i;
                arr[i][2] = i;
            }else{
                if(nums[i] == minK){
                    arr[i][0] = i;
                }else if(nums[i] != minK){
                    arr[i][0] = arr[i + 1][0];
                }
                if(nums[i] == maxK){
                    arr[i][1] = i;
                }else if(nums[i] != maxK){
                    arr[i][1] = arr[i + 1][1];
                }
                arr[i][2] = arr[i + 1][2];
            }
            count += (arr[i][2] - Math.max(arr[i][0], arr[i][1]));
            
        }
        return count;
    }
}