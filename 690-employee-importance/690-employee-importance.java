/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        HashMap<Integer, Integer> imprt = new HashMap<>();
        for(Employee employee : employees){
            graph.put(employee.id, employee.subordinates);
            imprt.put(employee.id, employee.importance);
        }        
        return dfs(graph, imprt, id);   
    }
    int dfs( HashMap<Integer, List<Integer>> graph, HashMap<Integer, Integer> imprt, int id){
        if(graph.get(id).isEmpty()){
            return imprt.get(id);
        }
        int ans = 0;
        for(int subOrd : graph.get(id)){
            ans += dfs(graph, imprt, subOrd);
        }
        return ans + imprt.get(id); 
    }
    
}
//2:53
//