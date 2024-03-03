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
    public ListNode removeNthFromEnd(ListNode head, int n) {
      ListNode newHead = new ListNode();
      newHead.next = head;
      ListNode toBeRemoved = newHead;
      ListNode node = newHead;
      int last = 0;
     while(node != null){
       if(last>=n+1){
         toBeRemoved = toBeRemoved.next;
       }
       node = node.next;
       last++;
     }
      ListNode curr = toBeRemoved.next.next;
      toBeRemoved.next = null;
      toBeRemoved.next = curr; 
        return newHead.next;
    
    }
}

