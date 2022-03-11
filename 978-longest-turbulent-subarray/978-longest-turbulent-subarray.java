class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int[] change = new int[arr.length -1];
        int ans = 1;
        int count = 0;
        for(int i = 0; i < arr.length - 1; i++){
                change[i] = arr[i] - arr[i + 1];
        }
        if(change.length > 0 && change[0] != 0) count = 2; 
        for(int i = 1; i < change.length; i++){
         if((change[i] > 0  && change[i - 1] < 0) || (change[i] < 0 && change[i - 1] > 0)){
                count++;
            }else{
                ans = Math.max(ans, count);
                count = (change[i] != 0) ? 2 : 1;
            }

        }
        return Math.max(ans, count);
    }
}