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
class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        
        while (head != null) {
            if (visited.contains(head)) return true;
            visited.add(head);
            head = head.next;
        }
        
        return false;
    }
}
