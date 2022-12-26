class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        HashMap<Integer, Integer> arrMap = new HashMap<>();
        HashMap<Integer, Integer> sorMap = new HashMap<>();
        int count = 0;
        for(int i = 0; i < arr.length; i++){
             int freq = arrMap.getOrDefault(arr[i], 0) + 1;
             arrMap.put(arr[i], freq);
             freq =  sorMap.getOrDefault(sorted[i], 0) + 1;
             sorMap.put(sorted[i], freq);
             if(isSor(arrMap, sorMap)){
                  arrMap = new HashMap<>();
                  sorMap = new HashMap<>();
                  count++;
             }
        }
        
        return count;
        
    }
       boolean isSor(HashMap<Integer, Integer> arrMap, HashMap<Integer, Integer> sorMap){
           if(sorMap.size() != arrMap.size()) return false;
           for(int key : arrMap.keySet()){
               if(!sorMap.containsKey(key) || !sorMap.get(key).equals(arrMap.get(key))){
                   return false;
               }
           }
           return true;
       }
    
}