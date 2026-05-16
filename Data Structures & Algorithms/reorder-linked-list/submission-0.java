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
    public void reorderList(ListNode head) {
        // find middle 
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        // slow - mid 
        // reverse the second half 
        ListNode second = slow.next;
        slow.next = null;
        ListNode prev = null;

        while(second!=null){
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }

        // merge two lists

        ListNode first = head;
        second = prev;
        while(second!=null){
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }
    }
}
