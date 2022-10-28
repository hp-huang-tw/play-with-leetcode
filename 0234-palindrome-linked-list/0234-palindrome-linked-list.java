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
    public boolean isPalindrome(ListNode head) {
        return splitListNode(head);
    }
    
    // TC: O(n), SC: O(1)
    private boolean splitListNode(ListNode head) {
        ListNode fast = head, slow = head;
        
        // find the middle
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next; // will stop at the middle
        }
        
        // revert the right hand portion
        // n1 -> n2 -> n3 -> n4
        //.n1 -> n2  null <- n3 <- n4
        ListNode prev = null, temp = null;
        while (slow != null) {
            temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        
        // check isPalindrome
        ListNode l = head, r = prev;
        while (r != null) {
            if (l.val != r.val) {
                return false;
            }
            l = l.next;
            r = r.next;
        }
        
        return true;
    }
    
    // TC: O(n), SC: O(n)
    private boolean arraySolution(ListNode head) {
        ArrayList<Integer> values = new ArrayList<>();
        
        while (head != null) {
            values.add(head.val);
            head = head.next;
        }
        
        int l = 0, r = values.size() - 1;
        
        while (l < r) {
            if (!values.get(l).equals(values.get(r))) {
                return false;
            }
            l++;
            r--;
        }
        
        return true;
    }
}