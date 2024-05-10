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
    public int pairSum(ListNode head) {

        // Space complexity o(n) and time is also O(n)
        // int i =0;
        // ListNode node = head;
        // HashMap<Integer, Integer> map = new HashMap<>();

        // while(node != null) {
        //     map.put(i, node.val);
        //     i++;
        //     node = node.next;
        // }
        // int result = -1;
        // int start = 0;
        // while(start <= (i/2 - 1)){
        //     result = Math.max(map.get(start) + map.get(i-start-1), result);
        //     start++;
        // }
        // return result;

        // Optimal solution

        ListNode slow = head;
        ListNode prev = new ListNode(0);
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;

            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;

            slow=temp;
        }

        int result = -1;
        while(slow != null) {
            result = Math.max(result, slow.val + prev.val);
            slow = slow.next;
            prev = prev.next;
        }
        return result;
    }
}