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
    public int pairSum(ListNode head) {
        List<Integer> ls = new ArrayList<>();
        while(head != null){
            ls.add(head.val);
            head = head.next;
        }
        int i = 0;
        int j = ls.size() -1;
        int max  = 0;
        while(i < j){
            max = Math.max(max, (ls.get(i) + ls.get(j)));
            i++;
            j--;
        }
        return max;
    }
}