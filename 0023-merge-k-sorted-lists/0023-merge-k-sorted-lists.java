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
    public ListNode mergeKLists(ListNode[] lists) {
       PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)-> a.val - b.val); 
        for(int i = 0; i < lists.length; i++){
            while(lists[i] != null){
            ListNode temp = new ListNode(lists[i].val);
                pq.add(temp);
                lists[i] = lists[i].next;
            }
        }
        
    
        ListNode head = pq.poll();
        ListNode tempo = head;
        while(!pq.isEmpty()){
            tempo.next = pq.poll();
            tempo = tempo.next;
        }
        return head;
    }
}