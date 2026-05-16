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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        for(int i = 0 ; i < left - 1 ; i++){
            prev = prev.next;
        }
        //     L   R
        // 1 2 3 4 5 6 
        ListNode sublistHead = prev.next;
        ListNode sublistTail = sublistHead;

        for(int i = 0 ; i < right - left ; i++){
           sublistTail = sublistTail.next;
        }

        ListNode nextNode = sublistTail.next;
        sublistTail.next = null;

        //reverse the LL
        ListNode newHead = reverseLL(sublistHead);
        prev.next = newHead;
        sublistHead.next = nextNode;

        return dummy.next;
    }

    ListNode reverseLL(ListNode head){
        // 1 -> 2 -> 3 -> NULL
                     
        // 1 -> NULL             
        ListNode prev = null;
        ListNode curr = head;

        while(curr!= null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}

/**

Brute force 
locate the sublist boundaries - disconnect it from the rest 
reverse the standarad list and reconnect the pieces. 

Better Approach 

one pass - when you get track of left ptr - start the reversal process until 
right - left + 1

and connect the pieces 

*/