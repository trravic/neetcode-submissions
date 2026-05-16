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

        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;
            
        ListNode p1 = list1, p2 = list2;
        ListNode head = new ListNode(0);
        if(p1!=null && p2!=null){
            if(p1.val <= p2.val){
                head = new ListNode(p1.val);
                p1 = p1.next;
            } else {
                head = new ListNode(p2.val);
                p2 = p2.next;
            }
        }
        ListNode tempHead = head;
        while(p1!=null && p2!=null){
            if(p1.val <= p2.val){
                tempHead.next = p1;
                p1 = p1.next;
            } else {
                tempHead.next = p2;
                p2 = p2.next;
            }
            tempHead = tempHead.next;
        }

        if(p2!=null){
            tempHead.next = p2;
        }

        if(p1!=null){
            tempHead.next = p1;
        }

        return head;
    }
}