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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        ListNode temp = head;
        ListNode next = head;
        int c = 1;
        while(temp != null){
            while(temp.next != null && c < k){
                temp = temp.next;
                c++;
            }
            if(c == k){
                c = 1;
                next = temp.next;
                temp.next = null;
                tail.next = reverseList(head);
                tail = head;
                head = next;
                temp = next;
            }else if( c > 0){
            tail.next = next;
            temp  = temp.next;    
        }
            
                    }
       
       return dummy.next; 
    }
    
  ListNode reverseList(ListNode head) {
      if(head == null || head.next == null){
                return head;
        }else{
                ListNode res = reverseList(head.next);
                head.next.next = head;
                head.next = null;
                return res;
        }
  }
} 