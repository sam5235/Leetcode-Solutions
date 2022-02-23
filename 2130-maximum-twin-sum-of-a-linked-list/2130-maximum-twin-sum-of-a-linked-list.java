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
    public int pairSum(ListNode head) {
       int max = 0;
        ListNode mid = middleNode(head);
         ListNode rev =  reverseList(mid);
        while(rev != null){
            max = Math.max(max,(head.val + rev.val));
            head = head.next;
            rev = rev.next;
        }
        return max;
    }
    
    public ListNode middleNode(ListNode head) {
        
        ListNode s = head;
        ListNode f = head;
        while(f != null && f.next != null){
            s = s.next;
            f = f.next.next;
        }
        return s ;
    }
    
     public ListNode reverseList(ListNode head) {
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
//reverse half