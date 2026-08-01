import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] ans = new int[n - k + 1];

        // Stores indices
        Deque<Integer> dq = new LinkedList<>();

        int index = 0;

        for (int i = 0; i < n; i++) {

            // Remove indices outside the current window
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // Remove smaller elements from the back
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            // Add current index
            dq.offerLast(i);

            // Store answer once first window is formed
            if (i >= k - 1) {
                ans[index++] = nums[dq.peekFirst()];
            }
        }

        return ans;
    }
}