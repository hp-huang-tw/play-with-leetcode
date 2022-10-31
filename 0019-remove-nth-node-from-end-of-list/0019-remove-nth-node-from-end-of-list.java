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
    // TC: O(n)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dumy = new ListNode(0, head);
        
        ListNode l = dumy, r = head;
        
        // move r to head + n
        while (n > 0 && r != null) {
            r = r.next;
            n--;
        }
        
        // move l & r togeter with n gap between them
        while (r != null) {
            l = l.next;
            r = r.next;
        }
        
        // remove nth node
        l.next = l.next.next;
        
        return dumy.next;
    }
}