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
        return arraySolution(head);
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