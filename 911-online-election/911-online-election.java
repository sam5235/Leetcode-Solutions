class TopVotedCandidate {
    int[] times;
    int[] recentLeaders;
    
    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        recentLeaders = new int[persons.length];
        Map<Integer, Integer> mostV = new HashMap<>();
        for(int i = 0; i < persons.length; i++){
            mostV.put(persons[i], mostV.getOrDefault(persons[i], 0) +1);
            if(i > 0 && mostV.get(persons[i]) < mostV.get(recentLeaders[i -1])){
                recentLeaders[i] = recentLeaders[i - 1];
            }else recentLeaders[i] = persons[i];
        }
    }
    
    public int q(int t) {
        int start = 0;
        int end = times.length - 1;
        int idx = times.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(t < times[mid]){
                idx = mid - 1;
                end = idx;
            }else if(t > times[mid]){
                start = mid + 1;
            }else {
                idx = mid;
                break;
        }
    }
    
        return recentLeaders[idx];
  }
}
    

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
//2:27
//