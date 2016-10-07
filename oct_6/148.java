/*
148. Sort List
Sort a linked list in O(n log n) time using constant space complexity.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeLists(ListNode l, ListNode r){
        ListNode m = new ListNode(0);
        ListNode temp = m;
        while(l != null && r !=null){
            if(l.val <= r.val) { m.next = l; l = l.next; }
            else { m.next = r; r = r.next;}
            m = m.next;
        }
        return temp.next;
    }
    
    public ListNode getMidNode(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode mid = getMidNode(head);
        ListNode rightHalf = null;
        if(mid != null) rightHalf = mid.next;
        ListNode leftHalf = head;
        mid.next = null;
        sortList(leftHalf);
        sortList(rightHalf);
        return mergeLists(leftHalf, rightHalf);
    }
}
