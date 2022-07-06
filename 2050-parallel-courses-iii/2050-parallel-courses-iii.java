class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < relations.length; i++){
            List<Integer> elem = graph.getOrDefault(relations[i][0], new ArrayList<>());
            elem.add(relations[i][1]);
            graph.put(relations[i][0], elem);
        }
        HashMap<Integer, Integer> duration = new HashMap<>();
        for(int i = 0; i < time.length;  i++){
            duration.put(i + 1, 0);
        }
        HashMap<Integer, Integer> incoming = new HashMap<>();
        for(int i=0; i < relations.length; i++){
            int freq = incoming.getOrDefault(relations[i][1], 0) + 1;
            incoming.put(relations[i][1], freq);
        }
        PriorityQueue<Integer> processed = new PriorityQueue<>((a,b) -> duration.get(b) - duration.get(a));
        for(int i = 1; i <= n; i++){
            if(!incoming.containsKey(i)) {
                processed.add(i);
                duration.put(i, time[i - 1]);
            }
        }
        PriorityQueue<Integer> nxtProcessed = new PriorityQueue<>((a,b) -> duration.get(b) - duration.get(a));
        int max = 0;
        int ans = ( n == 1) ? time[0] : 1;
        while(!processed.isEmpty()){
            int polled = processed.poll();
            //max = Math.max(max, duration.get(polled));
            if(graph.containsKey(polled)){
                for(int t : graph.get(polled)){
                    incoming.put(t, incoming.get(t) - 1);
                    duration.put(t, Math.max(duration.get(t), duration.get(polled)));
                    if(incoming.get(t) == 0){
                        duration.put(t, duration.get(t) + time[t - 1]);
                        ans = Math.max(ans, duration.get(t));
                        nxtProcessed.add(t);
                    }
                }
            }else ans = Math.max(ans, duration.get(polled));
            if(processed.isEmpty()){
                //ans += max;
                //max = 0;
                processed = nxtProcessed;
                nxtProcessed =  new PriorityQueue<>((a,b) -> duration.get(b) - duration.get(a));
            }
        }
        return ans;    
    }
}