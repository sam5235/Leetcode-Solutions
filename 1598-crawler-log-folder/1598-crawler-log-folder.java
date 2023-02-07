class Solution {
    public int minOperations(String[] logs) {
        int back = 0;
        for(int i = 0; i < logs.length; i++){
            if(logs[i].equals("../") && back > 0){
                back--;
            }else if(!logs[i].equals("./") && !logs[i].equals("../"))back++;
        }
        return  back;
    }
}