class Solution {
    public int findKthPositive(int[] arr, int k) {
        int num = 0, i = 0, n = arr.length;
        
        while(k > 0){
            num++;
            if(i < n && num == arr[i]){
                i++;
            }else k--;
        }
        return num;
        
    }
}