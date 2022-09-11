class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;
        int max = 0;
        for(int num : nums){
            set.add(num);
        }
         
        for(int num : nums){
            max = Math.max(max, num);
        }
        
                
        for(int i = 1; i <= n; i++){

            if(!set.contains(i)) return i;
        }   
        
        return max + 1;
    }
}