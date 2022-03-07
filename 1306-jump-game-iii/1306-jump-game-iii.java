class Solution {
    public boolean canReach(int[] arr, int start) {
         Queue<Integer> cur = new LinkedList<>();
         HashSet<Integer> set = new HashSet<>();
         cur.add(start);
         set.add(start);
         while(!cur.isEmpty()){
             int polled = cur.poll();
             if(arr[polled] == 0) return true;
             int left = polled + arr[polled];
             int right = polled - arr[polled];
             if(left >= 0 && left < arr.length && !set.contains(left)) {
                 cur.add(left);
                 set.add(left);
             }
             if(right >= 0 && right < arr.length && !set.contains(right)) {
                 cur.add(right);
                 set.add(right);
             }
         }
             return false;
    }
}
// 12:00
// 12:13
