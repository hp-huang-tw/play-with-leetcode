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
        return hashSet(head);
    }
    
    // time: O(n), space: O(n)
    private boolean hashSet(ListNode head) {
        HashSet<ListNode> visited = new HashSet<ListNode>();
        
        while (head != null) {
            if (visited.contains(head)) return true;
            visited.add(head);
            head = head.next;
        }
        return false;
    }
}