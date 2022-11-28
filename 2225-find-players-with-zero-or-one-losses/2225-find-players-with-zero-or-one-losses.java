class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer, Integer> score = new HashMap<>();
        for(int i = 0; i < matches.length; i++){
            int freq = score.getOrDefault(matches[i][1], 0) + 1;
            score.put(matches[i][1], freq);
        }
        
        HashSet<Integer> winners = new HashSet<>();
        List<Integer> lossers = new ArrayList<>();
        for(int i = 0; i < matches.length; i++){
            if(!score.containsKey(matches[i][0]))
                winners.add(matches[i][0]);
            if(score.containsKey(matches[i][1])){
                if(score.get(matches[i][1]) == 1)
                    lossers.add(matches[i][1]);
            }
        }
      List<List<Integer>> ans = new ArrayList<>();
        Collections.sort(lossers);
        ans.add(new ArrayList<>(winners));
        Collections.sort(ans.get(0));
        ans.add(lossers);
        return ans;

    }
}                                                                                                