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
    // [2,1,3,5,6,4,7]
    // 2->1->3->5->6->4->7     
    // a  b           
    
    // 2-----> 3 -> 5
    //     1---^
    // a   b
    //         a
    
    // 2-----> 3 -> 5 ------->
    //     1--------^
    //     b.  a
    
    // 2 -> 3 -> 1 -> 5 -> 6 -> 4 -> 7
    //      a.   bh   b
    
    // repeat the work.
    //        -> 6 -> 1 -> 5 -> 4
    //             -> 7 -> 1 -> 5 -> 4
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        
        ListNode a = head, b = head.next, bHead = head.next;
        while (b != null && b.next != null) {
            a.next = b.next;
            a = a.next;
            b.next = a.next;
            b = b.next;
        }
        
        a.next = bHead;
        return head;
    }
}