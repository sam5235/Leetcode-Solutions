class Solution {
    public int minimumEffort(int[][] tasks) {
        List<int[]> sortedTasks = Arrays.stream(tasks).sorted((a,b)-> {
            if(Integer.compare(b[1]-b[0],a[1]-a[0]) !=0 ){
                return Integer.compare(a[1]-a[0],b[1]-b[0]);
            }else{
                return Integer.compare(b[1],a[1]);
            }
        }).collect(Collectors.toList());
        
        int ans = sortedTasks.get(0)[1];
        
        for(int i=1; i< sortedTasks.size();i++){
            ans += sortedTasks.get(i)[0];
            if(ans < sortedTasks.get(i)[1]){
                ans = sortedTasks.get(i)[1];
            }
        }
        return ans;
    }
}