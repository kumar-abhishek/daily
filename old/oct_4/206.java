/*
206. Reverse Linked List
Reverse a singly linked list.
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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    //accepted
    public ListNode reverseListIterative(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode prev = null, next = head.next;
        ListNode temp = head;
        while(temp != null){
            temp.next = prev;
            prev = temp;
            temp = next;
            if(next != null) next = next.next;
        }
        return prev;
    }
}
