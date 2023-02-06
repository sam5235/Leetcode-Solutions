class Solution {
    public int racecar(int target) {
       
        Set<String> seen = new HashSet();
        seen.add("0_3");
        seen.add("0_1");
        
        Queue<List<Integer>> q = new LinkedList();
        q.offer(new ArrayList(Arrays.asList(0, 1)));
        int step = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            while(size != 0){
                size--;
                List<Integer> cur = q.poll();
                int position = cur.get(0);
                int speed = cur.get(1);
                List<Integer> A = new ArrayList(Arrays.asList(position+speed, speed*2));
                if(A.get(0) == target)
                    return step+1;
                if(A.get(0) < 2*target && A.get(0) > 0)
                    q.add(A);
                List<Integer> R = new ArrayList(Arrays.asList(position, speed>0? -1:1));
                String str = R.get(0)+"_"+(R.get(1)+2);
                if(!seen.contains(str)){
                    seen.add(str);
                    q.offer(R);
                }

            }
            step++;
        }
        
        return -1;
    }
}