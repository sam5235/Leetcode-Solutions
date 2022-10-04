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
      ListNode sum = new ListNode();
        ListNode head = sum;
        int a = 0;
        int b = 0;
        int remainder = 0;
        while(l1 != null || l2 != null){
           
            if(l1 != null){
                a = l1.val;
            }else  a = 0;
             if(l2 != null){
                b = l2.val;
            }else  b = 0;
          int c = a + b + remainder;
          remainder = 0;
            
           if(c> 9){
              sum.val = c % 10;
              remainder = 1; 
           }else  sum.val = c;
        if(l1 != null){
             l1 = l1.next;
        }
             if(l2 != null){
             l2 = l2.next;
        }
           
        
             if(l1 != null || l2 != null|| remainder == 1){
                 sum.next = new ListNode();
            }
            sum = sum.next;    
            
        }
        if(remainder == 1){
            sum.val = remainder;
        }
     return head;
    }
}