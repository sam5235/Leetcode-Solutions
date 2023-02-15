class Solution {
    private Boolean[][][] mem;
    public boolean checkValidString(String s) {
        int n= s.length();
        mem= new Boolean[101][101][101];
        return solve(s, 0, 0, 0);
    }
    public boolean solve(String s, int i, int left, int right){
        if(left<right)
            return false;
        if(i>=s.length()){
            if(left==right)
                return true;
            return false;
        }
        if(mem[i][left][right]!=null)
            return mem[i][left][right];

        char ch= s.charAt(i);
        if(ch=='('){
            return solve(s, i+1, left+1, right);
        }
        else if(ch==')'){
            return solve(s, i+1, left, right+1);  
        }
        else {
            return mem[i][left][right]=
                    ( solve(s, i+1, left, right) || 
                    solve(s, i+1, left+1, right) || 
                    solve(s, i+1, left, right+1) );
        }
    }
}