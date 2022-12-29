class Solution {
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        int high = Integer.MAX_VALUE;
        int low = uniqueCnt1 + uniqueCnt2;
        int size = uniqueCnt1 + uniqueCnt2;
        int ans = 0;
        while(low <= high){
            int mid = low + (high - low)/2;
            int div1 = mid - (mid / divisor1);
            int div2 = mid - (mid / divisor2);
            long inters =  mid - (mid /(((long)(divisor1 )* divisor2) / gcd(divisor1, divisor2))) ;
            if(uniqueCnt1 <= div1 && uniqueCnt2 <= div2 && size <= inters){

                ans = mid;
                high = mid - 1;
            }else low = mid + 1;

        }
        return ans;
    }
    int gcd(int n1, int n2){
        if(n2 == 0 )
            return n1;
        return gcd(n2, n1%n2);
    }
}