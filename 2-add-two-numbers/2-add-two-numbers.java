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
    
    ListNode headNode = new ListNode(0); // empty head [0|1]
    ListNode currNode = headNode; // currNode [0|1]
        
    int carry=0;
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = l1.val + l2.val + carry;
        carry=sum/10;
            
        currNode.next = new ListNode(sum%10); // 0|1 -> 7|2 -> 0|3 -> 8|4
        currNode=currNode.next; // 7|2, 0|3, 
        
        ListNode emptyNode=new ListNode(0);
        if (l1.next!=null && l2.next!=null)
            addTwoNumbers(l1.next, l2.next);
        else if (l1.next != null)
            addTwoNumbers(l1.next, emptyNode);
        else if (l2.next != null)
            addTwoNumbers(emptyNode, l2.next);
        else if (carry > 0) {
            currNode.next = new ListNode(carry);
            currNode = currNode.next;
        }
        
        return headNode.next;
    }
}