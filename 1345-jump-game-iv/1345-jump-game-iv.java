class Solution {
    public int minJumps(int[] arr) {
      Queue<Integer> curr = new LinkedList<>();
      HashMap<Integer, List<Integer>> map = new HashMap<>();
      HashSet<Integer> set = new HashSet<>();
      curr.add(0);
      set.add(0);  
      for(int i = 0; i < arr.length; i++){
           List<Integer> ls = map.getOrDefault(arr[i], new ArrayList<>());
          ls.add(i);
          map.put(arr[i], ls); 
      }  
      int length = 0;
      while(!curr.isEmpty()){
          int size = curr.size();
         
          for(int s = 0; s < size; s++){
              int polled = curr.poll();
                
              if(polled == arr.length - 1) return length;
              List<Integer> sub = map.getOrDefault(arr[polled], new ArrayList<>());

              for(int i = 0; i < sub.size(); i++){
                  if(!set.contains(sub.get(i))){
                      curr.add(sub.get(i));
                      set.add(sub.get(i));
                  }
              }
                map.remove(arr[polled]);
              
              if(polled + 1 < arr.length && !set.contains(polled + 1)){
                  curr.add(polled + 1);
                  set.add(polled + 1);
              }
              if(polled - 1 >= 0 && !set.contains(polled - 1)){
                  curr.add(polled - 1);
                  set.add(polled - 1);
              }

          }
          length++;
      } 
        return length;
        
    }
}