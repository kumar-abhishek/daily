/*
148. Sort List
Sort a linked list in O(n log n) time using constant space complexity.
*/

//accepted
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeLists(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val <= l2.val) {
            l1.next = mergeLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeLists(l1, l2.next);
            return l2;
        }
    } 
    
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head, fast = head, pre = head;
        while(fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        return mergeLists(sortList(head), sortList(slow));
    }
}

