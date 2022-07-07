class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int n = numCourses;
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < prerequisites.length; i++){
            List<Integer> elem = graph.getOrDefault(prerequisites[i][0], new ArrayList<>());
            elem.add(prerequisites[i][1]);
            graph.put(prerequisites[i][0], elem);
        }
        
        HashMap<Integer, Integer> incoming = new HashMap<>();
        for(int i = 0; i < prerequisites.length; i++){
            int freq = incoming.getOrDefault(prerequisites[i][1], 0) + 1;
            incoming.put(prerequisites[i][1], freq);
        }           
        

        Queue<Integer> processed = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(!incoming.containsKey(i)) processed.add(i);
        }
        List<TreeSet<Integer>> allPre = new ArrayList();
        for(int i = 0; i < n; i++){
            TreeSet<Integer> curr = new TreeSet<>();
            allPre.add(curr);
        }
        while(!processed.isEmpty()){
            int polled = processed.poll();
            if(graph.containsKey(polled)){
                for(int t : graph.get(polled)){
                    allPre.get(t).add(polled);
                    allPre.get(t).addAll(allPre.get(polled));
                    incoming.put(t, incoming.get(t) - 1);
                    if(incoming.get(t) == 0) processed.add(t);
                }
            }
        }
        
        List<Boolean> ans = new ArrayList<>();
        for(int i = 0; i < queries.length; i++){
            int curr = queries[i][1];
            if(allPre.get(curr).contains(queries[i][0])){
                ans.add(true);
            }else ans.add(false);
        }
        return ans;
    }
}