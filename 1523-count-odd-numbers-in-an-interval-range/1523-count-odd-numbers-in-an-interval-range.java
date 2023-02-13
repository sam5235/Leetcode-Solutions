class Solution {
    public int countOdds(int low, int high) {
        int ans = (int) Math.ceil((high - low +1) / 2.0);
        return low % 2 == 0 && high % 2 == 0 ? ans - 1: ans ;
    }
}