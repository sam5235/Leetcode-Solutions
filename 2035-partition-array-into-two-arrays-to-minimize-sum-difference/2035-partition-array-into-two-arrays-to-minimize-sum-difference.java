class Solution {
    List<TreeSet<Integer>> values = new ArrayList<>();
    int answer, sum;
    public int minimumDifference(int[] nums) {
        answer = Integer.MAX_VALUE;
        for(int i:nums) sum += i;
        for(int i=0; i<=nums.length/2; i++) values.add(new TreeSet<>());
        
        secondHalfBacktrack(nums, nums.length/2, 0, 0);
        backtrack(nums, 1, 0, 0); 
        
        return answer;
    }
    
    void backtrack(int[] nums, int index, int count, int cur) {
        combineAnswer(nums.length/2, count, cur);
        
        for(int i=index; i<nums.length/2; i++) {
            backtrack(nums, i+1, count+1, cur+nums[i]);
        }
        
    }
    void secondHalfBacktrack(int[] nums, int index, int count, int cur) {
        values.get(count).add(cur);

        for(int i=index; i<nums.length; i++) {
            secondHalfBacktrack(nums, i+1, count+1, cur+nums[i]);
        }
    }
    
    void combineAnswer(int n, int count, int cur) {
        int target = (sum - cur*2)/2; 
        if(values.get(n - count).floor(target) != null) {
            int v = values.get(n - count).floor(target);
            answer = Math.min(answer,  Math.abs(sum - (cur + v)*2));
        }
        if(values.get(n - count).higher(target) != null) {
           
            
            int v = values.get(n - count).higher(target);
            answer = Math.min(answer,  Math.abs(sum - (cur + v)*2));
        }
    }
}