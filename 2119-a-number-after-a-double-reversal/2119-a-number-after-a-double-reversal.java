class Solution {
    public boolean isSameAfterReversals(int num) {
        StringBuilder sb  = new StringBuilder(num + "");
        sb.reverse();
        int ans = Integer.parseInt(sb.toString());
        sb =  new StringBuilder(ans + "");
        sb.reverse();
        return Integer.parseInt(sb.toString()) == num;
    }
}