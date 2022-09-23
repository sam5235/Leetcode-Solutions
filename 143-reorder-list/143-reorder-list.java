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
    public void reorderList(ListNode head) {
        ListNode cut = head;        
        ListNode s = head;
        ListNode f = head;
        while(f.next != null && f.next.next != null){
            s = s.next;
            cut = cut.next;
            f = f.next.next;
        }
        ListNode head2 = (f.next != null)? reverse(s.next) : reverse(s);
        ListNode temp = head;
        while(temp != cut){
           ListNode next = temp.next;
            temp.next = null;
            temp.next = head2;
           ListNode nxt2 = head2.next;
            head2.next = null;
            head2.next = next;
            head2 = nxt2;
            temp = next;
            if(temp == cut) break;
        }
    }
    ListNode reverse(ListNode node){
       if(node == null || node.next == null){
           return node;
       }
        ListNode res = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return res;
    }
    
}