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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head.next == null) return head;

        ListNode node1 = head;
        ListNode node2 = head.next;

        while (node2 != null) {
            int gcdVal = getGCD(node1.val, node2.val);
            ListNode gcdNode = new ListNode(gcdVal);

            node1.next = gcdNode;
            gcdNode.next = node2;

            node1 = node2;
            node2 = node2.next;
        }

        return head;
    }

    private int getGCD(int val1, int val2) {
        while (val2!=0) {
            int temp = val2;
            val2 = val1 % val2;
            val1 = temp;
        }
        return val1;
    }
}