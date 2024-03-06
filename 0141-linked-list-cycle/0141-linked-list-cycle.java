/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
      int count = 0;
      while(head != null){
        head = head.next;
        count++;
        if(count>10000)
          return true;
      }
      return false;
    }
}