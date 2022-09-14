class Solution {
    public boolean isSameAfterReversals(int num) {
        return num == reverse(reverse(num));   
    }
     int reverse(int num){
          int ans = 0;
         while(num > 0){
             ans = (ans * 10) + (num % 10); 
             num /= 10;
         }
         return ans;
     }
}