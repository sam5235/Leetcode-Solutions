class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        helper(nums, 0, new ArrayList<>());
        answer.add(new ArrayList<>());
        return answer;
    }
    
    void helper(int[] nums, int idx, List<Integer> ls){
        if(idx == nums.length)
            return;
        for(int i=idx; i<nums.length; i++){
            ls.add(nums[i]);
            List<Integer> curr = new ArrayList<>(ls);
            answer.add(curr);
            helper(nums, i+1, ls);
            ls.remove(ls.size()-1);
        }
    }
}
