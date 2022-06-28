class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashMap<String, ArrayList<String>> graph = new HashMap<>();
        for(int i = 0; i < recipes.length; i++){
            for(String st: ingredients.get(i)){
                ArrayList<String> elem = graph.getOrDefault(st, new ArrayList<>());
                elem.add(recipes[i]);
                graph.put(st, elem);
            }
            
        }
        System.out.println(graph);
    
        HashMap<String, Integer> incoming = new HashMap<>();
        for(int i = 0; i < recipes.length; i++){
            incoming.put(recipes[i], ingredients.get(i).size());
        }

        Queue<String> q = new LinkedList<>();
        HashSet<String> checker = new HashSet<>();
        for(String st : supplies) checker.add(st);
        for(int i = 0; i < ingredients.size(); i++){
            for(String st : ingredients.get(i)){
                if(checker.contains(st) && !q.contains(st)) q.add(st);
                
            } 
        }
         System.out.println(q);
                
        List<String> ans = new ArrayList<>();
        while(!q.isEmpty()){
            String curr = q.poll();
            
                for(String st : graph.get(curr)){
                    incoming.put(st, incoming.get(st) - 1);
                    if(incoming.get(st) == 0){
                        if(graph.containsKey(st)){
                            q.add(st);
                        }
                        ans.add(st);
                    }
                } 
            }
        
        return ans;  
    }
}