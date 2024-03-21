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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode mergedList = new ListNode();
        if (list1.val < list2.val) {
            mergedList = list1;
            mergedList.next = mergeTwoLists(list1.next, list2);
        } else {
            mergedList = list2;
            mergedList.next = mergeTwoLists(list1, list2.next);
        }

        return mergedList;
    }
}

// 1       -> |  2 -> |     ->  4  
//  -> | 1    |          3         -> 4
