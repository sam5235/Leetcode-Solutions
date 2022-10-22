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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        helper(dummy, val);
        return dummy.next;
    }
    int helper(ListNode node, int val){
        if(node.next == null)
            return node.val;
        if(helper(node.next, val) == val)
            node.next = node.next.next;
        return node.val;
    }
}