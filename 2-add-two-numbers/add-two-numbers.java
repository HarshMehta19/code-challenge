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

            // System.out.println("val: " + value);
            tmp.next = new ListNode(value % 10);
            tmp = tmp.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        // while(l1 != null && l1.next != null) {
        //     tmp.next = new ListNode(l1.val);
        //     l1 = l1.next;
        // }

        // while (l2 != null && l2.next != null){
        //     tmp.next = new ListNode(l2.val);
        //     l2 = l2.next;
        // }

        // if(carry != 0)
        return node.next;
        
    }
}