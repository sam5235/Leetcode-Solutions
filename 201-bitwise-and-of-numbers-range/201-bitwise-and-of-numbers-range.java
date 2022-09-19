class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int ans = 0;
        int c = 0;
        int diff = right - left;
            while(diff > c && left != right){
                left >>= 1;
                right >>= 1;
                c++;
            }
        return (left & right) << c;
            
        }
    }
