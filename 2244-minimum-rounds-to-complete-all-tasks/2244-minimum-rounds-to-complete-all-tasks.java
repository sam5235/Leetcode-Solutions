class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < tasks.length; i++){
            int freq = map.getOrDefault(tasks[i], 0) + 1;
            map.put(tasks[i], freq);
        }
        int rounds = 0;
        for(int key: map.keySet()){
            if(map.get(key) == 1)
                return -1;
            if(map.get(key) % 3 == 0 )
                rounds += map.get(key) / 3;
            else{
                    rounds += map.get(key) / 3 + 1;
            } 
        }
        return rounds;
    }
}