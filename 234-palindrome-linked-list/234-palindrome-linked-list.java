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
    public boolean isPalindrome(ListNode head) {
        ListNode mid = findMid(head);
        ListNode rev = reverseList(mid);
        while(rev != null){
            if(head.val == rev.val){
                head = head.next;
                rev = rev.next;
            }else return false;
        }
        return true;
    }
    private ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return (fast != null) ? slow.next : slow;
    }
    private ListNode reverseList(ListNode head) {
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