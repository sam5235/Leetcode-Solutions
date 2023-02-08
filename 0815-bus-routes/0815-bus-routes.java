class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        int n = routes.length;
        HashMap<Integer, List<Integer>> route = new HashMap<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < routes[i].length; j++){
                List<Integer> ls = route.getOrDefault(routes[i][j], new ArrayList<>());
                ls.add(i);
                route.put(routes[i][j], ls);
            }
        }
        Queue<Integer> path = new LinkedList<>();
        HashSet<Integer> seen = new HashSet<>();
        boolean[] bus = new boolean[n];
        path.add(source);
        seen.add(source);
        int buses = 0;
        while(!path.isEmpty()){
             int size = path.size();
             for(int i = 0; i < size; i++){
                 int polled = path.poll();
                 if(target == polled)
                     return buses;
                 List<Integer> curr = route.get(polled);
                 for(int nxt = 0; nxt < curr.size(); nxt++){
                     if(!bus[curr.get(nxt)]){
                         int[] oneBus = routes[curr.get(nxt)];
                         for(int station = 0; station < oneBus.length; station++){
                                if(!seen.contains(oneBus[station])){
                                    path.add(oneBus[station]);
                                    seen.add(oneBus[station]);
                                }
                         }
                        bus[curr.get(nxt)] = true;
                     }
                 }
             }
             buses++;
        }
        return -1;
    }
}