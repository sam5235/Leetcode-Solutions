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
        return !isCycle(head, new HashSet<>());
    }
    boolean isCycle(ListNode node, HashSet<ListNode> set){
        if(node == null) return true;
            if(set.contains(node)) return false;
            set.add(node);
           return isCycle(node.next,set);
    }
}