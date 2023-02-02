class Solution {
    public long numberOfWays(String s) {
        long ans=0,prev0=0,prev1=0;
        int zero=0,one=0;
        for(int i=s.length()-1;i>=0;i--)
        {
            long pre0=0,pre1=0;
            if(s.charAt(i)=='1')
            {
                one++;
                ans=ans+prev0;
                pre1=prev1+zero;
                pre0=prev0;
            }
            else
            {
                zero++;
                ans=ans+prev1;
                pre0=prev0+one;
                pre1=prev1;
            }
            prev0=pre0;
            prev1=pre1;
        }
        return ans;
    }
}