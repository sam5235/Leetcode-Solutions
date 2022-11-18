class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int num : nums)
            xor ^= num;
        int shift = 0;
        int temp = xor;
        while(temp != 0){
            if((temp & 1) == 1){
                break;
            }
            shift++;
            temp >>= 1;
        }
        int ans = 0;
        for(int num : nums){
            if(((num >> shift)  & 1)== 1){
                 ans ^= num;
                
            }
               
        }
        int uniq[] = new int[2];
        uniq[0] = ans ^ xor;
        uniq[1] = ans;
        return uniq;
    }
}