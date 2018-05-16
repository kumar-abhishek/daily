/*
203. Remove Linked List Elements
Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
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
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        ListNode prev = new ListNode(0);
        prev.next = head;
        ListNode temp = prev;
        
        while(head != null) {
            if(head.val == val){
                prev.next = head.next;
            } else {
                prev = prev.next;
            }
            head = prev.next;
        }
        return temp.next;
    }
}
