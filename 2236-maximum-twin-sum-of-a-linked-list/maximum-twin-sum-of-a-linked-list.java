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
        int i =0;
        ListNode node = head;
        HashMap<Integer, Integer> map = new HashMap<>();

        while(node != null) {
            map.put(i, node.val);
            i++;
            node = node.next;
        }
        // System.out.println("i is: "+ i);
        int result = -1;
        int start = 0;
        while(start <= (i/2 - 1)){
            result = Math.max(map.get(start) + map.get(i-start-1), result);
            start++;
        }
        return result;
    }
}