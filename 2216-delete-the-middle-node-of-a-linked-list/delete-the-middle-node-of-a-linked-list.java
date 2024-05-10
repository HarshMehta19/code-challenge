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
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null) return null;
        ListNode curr = new ListNode(0, head);
        ListNode next = head;
        // curr.next = head;
        while(next != null && next.next != null) {
            curr = curr.next;
            next = next.next.next;
        }

        curr.next = curr.next.next;

        return head;
    }
}