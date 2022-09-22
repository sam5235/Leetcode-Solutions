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
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode head2  = head.next;
        head.next = null;
        while(head2 != null){
            ListNode temp = dummy;
            while(temp.next != null){
                if(temp.next.val >= head2.val){
                    ListNode nxt1 = head2.next;
                    head2.next = null;
                    ListNode nxt2 = temp.next;
                    temp.next = null;
                    temp.next = head2;
                    head2.next = nxt2;
                    head2 = nxt1;
                    break;
                }
                else temp = temp.next;
                if(temp.next == null){
                    temp.next = head2;
                    ListNode nxt = head2.next;
                    head2.next = null;
                    head2 = nxt;
                    break;
                } 
                
            }
            
            ListNode n = dummy;
            
        }
        return dummy.next;
    }
}