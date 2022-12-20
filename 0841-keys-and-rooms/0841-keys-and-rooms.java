class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] boolArr = new boolean[n];
        Queue<Integer> curr = new LinkedList<>();
        curr.add(0);
        boolArr[0] = true;
        int door = 1;
        
        while(!curr.isEmpty()){
            int size = curr.size();
            for(int i = 0; i < size; i++){
                int poll = curr.poll();
                for(int j = 0; j < rooms.get(poll).size(); j++){
                    
                
                    if(!boolArr[rooms.get(poll).get(j)]){
                        curr.add(rooms.get(poll).get(j));
                        boolArr[rooms.get(poll).get(j)] = true;
                        door++;
                    }
                }         
            }
            
        }
        return door == n;
    }
}