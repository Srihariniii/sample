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

    public ListNode removeZeroSumSublists(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        HashMap<Integer, ListNode> map = new HashMap<>();

        int prefix = 0;
        ListNode curr = dummy;

        // First pass: store the last node for each prefix sum
        while (curr != null) {
            prefix += curr.val;
            map.put(prefix, curr);
            curr = curr.next;
        }

        // Second pass: remove zero-sum sequences
        prefix = 0;
        curr = dummy;

        while (curr != null) {
            prefix += curr.val;
            curr.next = map.get(prefix).next;
            curr = curr.next;
        }

        return dummy.next;
    }
}