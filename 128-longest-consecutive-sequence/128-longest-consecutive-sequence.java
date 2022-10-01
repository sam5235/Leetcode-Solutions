class Solution {
    public int longestConsecutive(int[] nums) {
        int[] ans = new int[nums.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
           ans[i] = i;
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++){
           if(!visited.contains(nums[i])){
               find(ans, map, visited, nums[i]);
           }    
        }

        map = new HashMap<>();
        for(int i = 0; i < ans.length; i++){
            int freq =  map.getOrDefault(ans[i], 0) + 1;
            map.put(ans[i], freq);
        }
        int longest = 0;
        for(int key : map.keySet()) longest = Math.max(longest, map.get(key)); 
        return longest;
    }
    
    int find(int[] ans, HashMap<Integer, Integer> map, HashSet<Integer> visited, int a){
        visited.add(a);
        if(!map.containsKey(a - 1)) return ans[map.get(a)];
        if(visited.contains(a - 1)) return ans[map.get(a)] = ans[map.get(a - 1)];
        return ans[map.get(a)] = find(ans, map, visited, a - 1);
    }
}