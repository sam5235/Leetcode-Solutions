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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode temp = head;
        int carry = 0;
        while(l1 != null || l2 != null){
            int num1 = l1 ==null? 0:l1.val;
            int num2 = l2==null?0:l2.val;
            int sum = num1+num2+carry;
            ListNode next;
            if(sum>9){
                next = new ListNode((sum)%10);
                carry = 1;               
            }else{
                next = new ListNode(sum);
                carry = 0;
            }
            temp.next = next;
            temp = next;
            l1 = l1!=null? l1.next:null;
            l2 = l2!=null? l2.next:null;
        }
        if(carry == 1){
            temp.next = new ListNode(carry);
        }
        return head.next;
    }
}
/*

2->4->1->3
5->6->4

7->0->8

*/