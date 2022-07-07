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
    public ListNode sortList(ListNode head) {
        PriorityQueue<Integer> sorted = new PriorityQueue<>((a,b)-> a - b);
        if(head == null) return head;
        while(head != null){
             sorted.add(head.val);
            head = head.next;
        }
        System.out.println(sorted);
        // ListNode curr = new ListNode();
        // 
        
        ListNode curr = new ListNode(sorted.poll());     
        ListNode ans = curr;
        while(!sorted.isEmpty()){
            ListNode temp = new ListNode(sorted.poll());
             curr.next = temp;
            curr = temp;
            
        }
        return ans;
    }
}