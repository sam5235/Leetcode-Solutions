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
    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        ListNode[] newHead = new ListNode[1];
        helper(head, newHead);
        return newHead[0];
    }
    ListNode helper(ListNode node, ListNode[] newHead){
        if(node.next == null){
            newHead[0] = node;
            return node;
        }else{
            ListNode temp = helper(node.next, newHead);
            temp.next = node;
            node.next = null;
            return node;
        }
    }
}