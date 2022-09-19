class Solution {
    public int bitwiseComplement(int n) {
       int ans = 0;
        int c = 0;
        if(n == 0) return 1;
        while(n > 0){
            if((n & 1) == 0){
                ans += (1 << c);
            }
            c++;
            n >>= 1;
        }
        return ans;  
    }
}