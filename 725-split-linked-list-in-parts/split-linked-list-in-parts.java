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
    public ListNode[] splitListToParts(ListNode head, int k) {

        
        int n = 0;
        ListNode temp = head;

        while (temp != null) {
            n++;
            temp = temp.next;
        }

       
        int partSize = n / k;
        int extra = n % k;

        ListNode[] ans = new ListNode[k];

        ListNode curr = head;

        for (int i = 0; i < k; i++) {

            if (curr == null) {
                ans[i] = null;
                continue;
            }

            ans[i] = curr;

            int size = partSize;
            if (extra > 0) {
                size++;
                extra--;
            }

           
            for (int j = 1; j < size; j++) {
                curr = curr.next;
            }

            
            ListNode next = curr.next;
            curr.next = null;
            curr = next;
        }

        return ans;
    }
}