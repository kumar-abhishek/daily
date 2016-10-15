/*
61. Rotate List
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k ==0) return head;
        int n = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            n += 1;
        }
        k %= n; // if k>n
        if(k == 0) return head;
        // reach (n-k-1)th node
        temp = head;
        for(int i =0;i<n-k-1;i++) temp = temp.next;
        ListNode newHead = temp.next;
        temp.next= null;
        
        //reach the tail of the right half
        temp = newHead;
        while(temp.next != null) temp = temp.next;
        temp.next = head;
        
        
        return newHead;
    }
}
