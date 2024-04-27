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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode tmp = node;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
            int value = carry + (l1 != null  ? l1.val : 0) + (l2 != null  ? l2.val : 0);
            carry = value / 10;

            tmp.next = new ListNode(value % 10);
            tmp = tmp.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        return node.next;
        
    }
}