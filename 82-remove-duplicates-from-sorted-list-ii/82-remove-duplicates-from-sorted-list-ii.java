/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();
        while(head != null){
            int freq = map.getOrDefault(head.val, 0) + 1;
            map.put(head.val, freq);
            head = head.next;
        }
        
        Queue<Integer> pq = new PriorityQueue<>((a,b)-> a - b);
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int val = entry.getValue();
            if(val == 1){
            pq.add(entry.getKey());
            }
        }
        if (!pq.isEmpty()) {
            ListNode temp = new ListNode( pq.poll());
            ListNode ans = temp;
        
        while(!pq.isEmpty()){
            temp.next =  new ListNode( pq.poll());
            temp = temp.next;
        }
        return ans;
        }
        return head;
    }
}