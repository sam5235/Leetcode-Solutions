/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     public int f(int x, int y);
 * };
 */

class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
      List<List<Integer>> ans = new ArrayList<>();
        for(int x = 1; x <=1000; x++){
            int low = 1;
            int high = 1000;
            while(low <= high){
                int mid = low + (high - low)/2;
                if(customfunction.f(x, mid) < z){
                    low = mid + 1;
                }else if(customfunction.f(x, mid) > z){
                    high = mid - 1;
                }else {
                    ans.add(new ArrayList<>(Arrays.asList(x, mid)));
                    break;
                }
            
             }
        }   
        return ans;
        
    }
}