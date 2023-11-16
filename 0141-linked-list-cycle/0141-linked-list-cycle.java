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
        Set<ListNode> visited = new HashSet<>();
        
        while (head != null) {
            // If the node is already in the HashSet, there is a cycle
            if (visited.contains(head)) {
                return true;
            }
            
            // Add the current node to the HashSet
            visited.add(head);
            // Move to the next node
            head = head.next;
        }
        
        // No cycle found
        return false;
    }
}