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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    
         ListNode head = new ListNode();
         ListNode ans = head;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                ans.next = list1;
                list1 = list1.next;
                ans = ans.next;
            }else {
                ans.next = list2;
                list2 = list2.next;
                ans = ans.next;
            }
        }
        ListNode temp = (list1 == null) ? list2 : list1;
        while(temp != null){
            ans.next  = temp;
            temp = temp.next;
            ans = ans.next;
        }
        return head.next;
     }
    }
