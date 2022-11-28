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

    
    // Bottom-Up Merge Sort
    
    // Top-Down Merge Sort (Dive & Conquer)
    // TC: O(nlog(n)). 
    // Step1. split list to one node (log(n))
    //.  4->2 1->3
    // Step2. merge them (n * log(n))
    // SC: O(log(n))
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        // split a list as two list
        ListNode left = head;
        ListNode mid = getMid(head);
        ListNode tmp = mid.next;
        mid.next = null;
        ListNode right = tmp;
        
        // recursive to split left & right list
        left = sortList(left);
        right = sortList(right);
        
        return merge(left, right);
        
    }
    
    private ListNode getMid(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy  = new ListNode();
        ListNode tail = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        
        if (l1 != null) {
            tail.next = l1;
        } else {
            tail.next = l2;
        }
        
        return dummy.next;
    }
    
}