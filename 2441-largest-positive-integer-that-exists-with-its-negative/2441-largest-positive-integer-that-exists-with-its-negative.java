class Solution {
    public int findMaxK(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }
        
        int max = 0;
        for(int n : nums){
            if(set.contains(n * -1)){
                max = Math.max(max, n);
            }
        }
        
        return max == 0 ? -1 : max;
    }
}