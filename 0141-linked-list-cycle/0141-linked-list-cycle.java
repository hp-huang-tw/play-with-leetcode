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
        if (head == null || head.next == null) {
            return false;
        } // No cycle if the list is empty or has only one node
        
        ListNode slow = head, fast = head.next;
        
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            } // No cycle if the fast pointer reaches the end
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return true; // There is a cycle if the slow and fast pointers meet
    }
}