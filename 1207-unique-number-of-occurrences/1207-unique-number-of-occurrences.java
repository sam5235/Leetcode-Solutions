class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashSet<Integer> uniq = new HashSet<>();
        Arrays.sort(arr);
        int un = 0;
        for(int i = 0; i < arr.length; i++){
            if(i < arr.length - 1 && arr[i] == arr[i + 1]){
                un++;
            }else{
                un++;
                if(!uniq.contains(un)){
                    uniq.add(un);
                    un = 0;
                }else return false;
            }
            
        }
        return true;
    }
}