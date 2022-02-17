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
    public int[] nextLargerNodes(ListNode head) {
        int size = 0;
        Stack<int[]> st = new Stack<>();
        ListNode temp = head;
       while(temp != null){
           size++;
           temp = temp.next;
       }
        int[] ans = new int[size];
        for(int i = 0; i < size; i++){
          while(!st.empty() && st.peek()[0] < head.val){
              ans[st.pop()[1]] = head.val; 
             
          }
            st.push(new int[]{head.val,i});
            head = head.next;
           
        }
        return ans;
    }
}