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
        Queue<Integer> q = new PriorityQueue<>((a,b) -> a - b);
        ListNode ans = new  ListNode() ;
        for(int i = 0; i < lists.length; i++){
            while(lists[i] != null){
                q.add(lists[i].val);
                lists[i] = lists[i].next;
            }
        }
        ListNode temp = ans;
        
        while(!q.isEmpty()){
            ans.next = new ListNode(q.poll());
            ans = ans.next;
        }
       return temp.next;
    }
}