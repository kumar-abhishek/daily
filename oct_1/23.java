/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Show Company Tags
Show Tags
Show Similar Problems
*/
import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new Comparator<ListNode>(){
                @Override
                public int compare(ListNode l1, ListNode l2) { return l1.val-l2.val; }
            });

        ListNode mergedList = new ListNode(0);
        ListNode head = mergedList;
        for(int i=0;i<lists.length;i++){
            if(lists[i] != null){
                pq.offer(lists[i]);
            }
        }
        while(!pq.isEmpty()){
            ListNode l = pq.poll();
            if(l.next != null){
                pq.offer(l.next);
            }
            mergedList.next = l;
            mergedList = mergedList.next;
        }
        return head.next;
    }
}
