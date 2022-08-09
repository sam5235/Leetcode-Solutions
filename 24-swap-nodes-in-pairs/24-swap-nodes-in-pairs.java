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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode h2 = head.next;
        ListNode ans = h2;
        ListNode h3;
        while(h2 !=  null){
            h3 = h2.next;
            h2.next = null;
            h2.next = head;
            head.next = null;
            head.next = (h3 != null && h3.next != null ? h3.next : h3);
            head = h3;
            h2 = (h3 != null ? h3.next : h3 ) ;
        }
      
        return ans;
    }
}