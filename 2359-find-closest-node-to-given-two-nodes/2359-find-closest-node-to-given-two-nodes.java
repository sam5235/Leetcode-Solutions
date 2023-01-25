class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        HashMap<Integer, Integer> seen1 = new HashMap<>();
        HashMap<Integer, Integer> seen2 = new HashMap<>();
        q1.add(node1);
        q2.add(node2);
        seen1.put(node1,0);
        seen2.put(node2, 0);
        int[] node = {100001, 100001};
        helper(edges, q1,0,0, q2, seen1, seen2,node);
        return node[0] == 100001 ? -1 : node[0];
        
    }
    void helper(int[] edges, Queue<Integer> q1,int steps1, int steps2, Queue<Integer> q2, HashMap<Integer, Integer> seen1, HashMap<Integer, Integer> seen2, int[] node){
        if(q1.isEmpty() && q2.isEmpty())
            return;
        if(!q1.isEmpty()){
            int polled = q1.poll();
            steps1++;
            seen1.put(polled, steps1);
            if(seen2.containsKey(polled)){
                int dist = Math.max(seen1.get(polled),seen2.get(polled));
                if(node[1] >= dist){
                    node[0] =  Math.min(node[0], polled);
                    node[1] = dist;
                }
            }
            if(edges[polled] != -1 && !seen1.containsKey(edges[polled]))
                q1.add(edges[polled]);
        }
            helper(edges, q2,steps2, steps1, q1, seen2, seen1, node);
        
    }
}