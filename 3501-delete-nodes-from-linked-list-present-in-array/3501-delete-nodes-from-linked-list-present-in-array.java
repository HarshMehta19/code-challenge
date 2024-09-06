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
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode result = new ListNode(-1);
        ListNode node = result;
        Set<Integer> set = new HashSet();
        for(int num: nums) 
            set.add(num);
        
        while(head != null) {
            if(!set.contains(head.val)){
                node.next = head;
                node = node.next;
            }
            head = head.next;
        }
        node.next = null;
        return result.next;

    }
}