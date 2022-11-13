class Solution {
    public int[] plusOne(int[] digits) {
        int[] ans = new int[digits.length + 1];
        int bit = 1;
        for(int i = digits.length - 1; i >= 0; i--){
            ans[i + 1] = digits[i]; 
            if(bit > 0){
                if(ans[i + 1] < 9){
                    ans [i + 1] += 1;
                    bit--;
                }else
                    ans[i + 1] = 0;
            }
        }
        if(bit == 1){
            ans[0] = 1;
        }
        if(ans[0] == 0){
            int[] newAns = new int[ans.length - 1];
            for(int i = 0; i < ans.length - 1; i++)
                newAns[i] = ans[i +1];
         return newAns;
        }
        return ans;
    }
}
