class Solution {
    public int[] plusOne(int[] digits) {
        int[] ans = new int[digits.length + 1];
        int bit = 1;
        for(int i = digits.length - 1; i >= 0; i--){
            if(bit > 0){
                if(digits[i] < 9){
                    digits[i] += 1;
                    bit--;
                }else
                    digits[i] = 0;
            }
        }
        if(bit == 1){
            ans[0] = 1;
            return ans;
        }
        
        return digits;
    }
}
