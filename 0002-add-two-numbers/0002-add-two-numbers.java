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
    
    int carry = 0;
    
    private ListNode headNode = new ListNode(0);
    
    private ListNode currNode = headNode;
    
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = l1.val + l2.val + carry;
        carry = sum/10;
        
        currNode.next = new ListNode(sum%10);
        currNode = currNode.next;
        
        ListNode emptyNode = new ListNode(0);
        if (l1.next != null && l2.next != null) {
            addTwoNumbers(l1.next, l2.next);
        } else if (l1.next != null) {
            addTwoNumbers(l1.next, emptyNode);
        } else if (l2.next != null) {
             addTwoNumbers(emptyNode, l2.next);
        } else if (carry > 0) {
            currNode.next = new ListNode(carry);
            currNode = currNode.next;
        }
        
        return headNode.next;
    }
    
}
