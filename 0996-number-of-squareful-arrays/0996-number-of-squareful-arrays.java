class Solution {
    int sum;
    public int numSquarefulPerms(int[] A) {
        sum=0;
        backtrack(A, new boolean[A.length], new int[A.length], 0);
        return sum;
    }
    public void backtrack(int[] A, boolean[] used, int[] cur, int index){
        
        if(index==A.length){
            sum++;
            return; 
        }
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<A.length; i++){
            if(used[i] || set.contains(A[i]))
                continue;

            if(index==0||check2(cur[index-1],A[i])){
                cur[index] = A[i];
                set.add(A[i]);
                used[i] = true;
                backtrack(A, used, cur, index+1);
                used[i] = false;
            }   
        }   
    }
    public boolean check2(int a, int b){
        int c = a+b;
        int x = (int)Math.sqrt(c);
        return Math.pow(x,2)==c;
    }
}