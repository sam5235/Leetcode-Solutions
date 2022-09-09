class Solution {
    public int maxJumps(int[] arr, int d) {
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, helper(arr, i, map, d));
        }
        return max;
        
    }
    
    int helper(int[] arr, int i, HashMap<Integer, Integer> memo, int d){
        if(outBound(i, arr.length)) return 0;
        if(memo.containsKey(i)) return memo.get(i);
        
        int left = 0, right = 0;
        
        for(int x = 1; x <= d; x++){
            if(!outBound(i - x, arr.length) && arr[i - x] < arr[i]){
                
            left = Math.max(left, helper(arr, i - x, memo, d));
            }else  break;
        }
        
         for(int x = 1; x <= d; x++){
            if(!outBound(i + x, arr.length) && arr[i + x] < arr[i]){
            right = Math.max(right, helper(arr, i + x, memo, d));
        }else break; 
        }
        
        memo.put(i, 1 +  Math.max(left, right));
        return memo.get(i);
    }
    
    Boolean outBound(int i, int n){
        return i < 0 || i >= n;
    }
}