class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, List<int[]>> graph = new HashMap<>();
        for(int i = 0; i < times.length; i++){
            List<int[]> ls = graph.getOrDefault(times[i][0], new ArrayList<>());
            ls.add(new int[]{times[i][1], times[i][2]});
            graph.put(times[i][0], ls);
        }
        
        PriorityQueue<Pair> djks= new PriorityQueue<>();
        djks.add(new Pair(k, 0));
        HashSet<Integer> seen = new HashSet<>();
        int processed = 0;
        int min = Integer.MIN_VALUE;
        while(!djks.isEmpty() && processed != n){
            Pair polled = djks.poll();
            if(!seen.contains(polled.node))
                processed++;
            seen.add(polled.node);
            min = Math.max(min, polled.val);
            int node = polled.node;
            for(int i = 0; graph.containsKey(node) && i < graph.get(node).size(); i++){
                int[] nxt = graph.get(node).get(i);
                if(!seen.contains(nxt[0]))
                   djks.add(new Pair(nxt[0], polled.val + nxt[1]));
            }
        }
        if(processed != n)
            return -1;
        return min;
        
    }
}

class Pair implements Comparable<Pair>{
    int node;
    int val;
    Pair(int n, int v){
        val = v;
        node = n;
    }
    
   public int compareTo(Pair nxt){
        return val - nxt.val;
    }
}