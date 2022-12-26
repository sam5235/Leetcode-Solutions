class Solution {
    public boolean canJump(int[] nums) {
        Queue<Integer> curr = new LinkedList<>();
        boolean[] boolArr = new boolean[nums.length];
        boolArr[0] = true;
        curr.add(0);
        while(!curr.isEmpty()){
            int size = curr.size();
            for(int i = 0; i < size; i++){
                int polled = curr.poll();
                if(polled >= nums.length - 1) return true;
                for(int j = polled + 1; j <= polled + nums[polled]; j++){
                        if(j >= nums.length - 1) return true;
                        if(!boolArr[j]){
                         curr.add(j); 
                         boolArr[j] = true;   
                        }
                }
            }
        }
        return false;
    }
}