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
        return twoPointers(headA, headB);
    }
    
    private ListNode twoPointers(ListNode headA, ListNode headB) {
        ListNode l1 = headA, l2 = headB;
        
        while (l1 != l2) {
            l1 = (l1 != null) ? l1.next : headB;
            l2 = (l2 != null) ? l2.next : headA;
        }
        
        return l1;
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