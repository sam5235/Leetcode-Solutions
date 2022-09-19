class Solution {
    public int findComplement(int num) {
        int ans = 0;
        int c = 0;
        while(num > 0){
            if((num & 1) == 0){
                ans += (1 << c);
            }
            c++;
            num >>= 1;
        }
        return ans;
    }
}