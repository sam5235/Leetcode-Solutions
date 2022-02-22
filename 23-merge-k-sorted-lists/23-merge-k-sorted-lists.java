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
        Queue<ListNode> q = new PriorityQueue<>((a,b) -> a.val - b.val);
        ListNode ans = new  ListNode() ;
        for(int i = 0; i < lists.length; i++){
          if(lists[i] != null)  q.add(lists[i]);
        }
        
        ListNode temp = ans;
        while(!q.isEmpty()){
             ListNode min = q.poll();
             temp.next = min;
             temp = temp.next;
            if(min.next != null){
                 q.add(min.next);
            }        
        }
       return ans.next;
    }
}