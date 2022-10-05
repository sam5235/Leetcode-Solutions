class Solution {
    public int commonFactors(int a, int b) {
        int small = a <= b ? a : b;
        int large = a >= b ? a : b;
        int ans = 0;
        for(int i = 1; i <= Math.sqrt(small); i++){
            if(small % i == 0){
              int j = small / i;
                if(large % i == 0)ans++;
                if(large % j == 0 && i != j)ans++;
            }
        }
        return ans;
    }
}