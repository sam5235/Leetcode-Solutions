class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for(int[] preq : prerequisites){
            ArrayList<Integer> paths = graph.getOrDefault(preq[1], new ArrayList<Integer>());
            paths.add(preq[0]);
            graph.put(preq[1], paths);
        }
        HashMap<Integer, Integer> incoming  = new HashMap<>();
        for(int[] preq : prerequisites){
            int freq = incoming.getOrDefault(preq[0], 0) + 1;
            incoming.put(preq[0], freq);
        }
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int course = 0; course< numCourses; course++){
            if(!incoming.containsKey(course)){
                q.add(course);
                count++;
            }
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            ArrayList<Integer> paths = graph.getOrDefault(curr, new ArrayList<>());
            for(int course : paths){
                incoming.put(course ,incoming.get(course) - 1);

                if(incoming.get(course) == 0){
                    q.add(course);
                    count++;
                }
            }
        }
        return count == numCourses;
    }
}