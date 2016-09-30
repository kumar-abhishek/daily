/*
2. Add Two Numbers 
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        
        
        ListNode l = new ListNode(-1);
        ListNode start = l;
        int carry = 0;
        while(l1 != null || l2 != null){
            int sum = 0;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            } 
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            l.next = new ListNode(sum%10);
            carry = sum/10;
            l = l.next;
        }
        if(carry != 0){
            l.next = new ListNode(carry);
        }
    
        return start.next;
    }
}
