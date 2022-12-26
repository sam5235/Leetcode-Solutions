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
        return soln(head);
    }
    
    ListNode soln(ListNode head){
        if(head == null || head.next == null )
            return head;
        ListNode[] sides = div(head);
        ListNode left = soln(sides[0]);
        ListNode right = soln(sides[1]);

        return merge(left, right);
    }
    
    ListNode[] div(ListNode head){
        ListNode cut = head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            cut = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        cut.next = null;
        return new ListNode[]{head, slow};
    }
    
    ListNode merge(ListNode h1, ListNode h2){
        ListNode head = new ListNode();
        ListNode temp = head;
        while(h1 != null || h2 != null){
            if(h1 != null && h2 != null){
                 if(h1.val <= h2.val){
                     temp.next = new ListNode(h1.val);
                     h1 = h1.next;
                     temp = temp.next;
                 }else{
                     temp.next =  new ListNode(h2.val);
                     h2 = h2.next;
                     temp = temp.next;
                 }
            }else{
                     ListNode nxt = h1 != null? h1:h2;
                     h1 = h2 = null;
                     while(nxt != null){
                         temp.next = new ListNode(nxt.val);
                         nxt = nxt.next;
                         temp = temp.next;
                     }
                 }

            
        }
        return head.next;
    }
}