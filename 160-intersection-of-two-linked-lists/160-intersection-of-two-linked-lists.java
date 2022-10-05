/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        return hashSet(headA, headB);
    }
    
    // time: O(n+m), space: O(n)
    private ListNode hashSet(ListNode headA, ListNode headB) {
        HashSet<ListNode> visited = new HashSet<ListNode>();
        while (headA != null) {
            visited.add(headA);
            headA = headA.next;
        }
        
        while (headB !=null) {
            if (visited. contains(headB)) return headB;
            headB = headB.next;
        }
        
        return null;
    }
}