class Solution {
    int mod = 1_000_000_007;
    long[][] tri;
    List<Integer> primes;
    public int[] waysToFillArray(int[][] queries) {
        int len = queries.length;
        int[] res = new int[len];
        primes = getPrimes(100);
        tri = getTri(10015, 15);
        for(int i=0; i<len; i++)
            res[i] = calculate(queries[i][0], queries[i][1]);
        return res;
    }
    
    public List<Integer> getPrimes(int limit){
        boolean[] notPrime = new boolean[limit+1];
        List<Integer> res = new ArrayList();
        for(int i=2; i<=limit; i++){
            if(!notPrime[i]){
                res.add(i);
                for(int j=i*i; j<=limit; j+=i)
                    notPrime[j]=true;
            }
        }
        return res;
    }
    
    public long[][] getTri(int m, int n){
        long[][] res = new long[m+1][n+1];
        for(int i=0; i<=m; i++){
            res[i][0]=1;
            for(int j=1; j<=Math.min(n, i); j++)
                res[i][j] = (res[i-1][j-1]+res[i-1][j])%mod;
        }
        return res;
    }
    
    public int calculate(int n, int target){
        long res = 1;
        for(int prime : primes){
            if(prime > target)
                break;
            int cnt = 0;
            while(target%prime==0){
                cnt++;
                target/=prime;
            }
            res = (res * tri[cnt+n-1][cnt])%mod;
        }
        return target>1 ? (int)(res*n%mod) : (int)res;
    }
}