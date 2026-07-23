class Solution {

    public boolean circularArrayLoop(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < n; i++) {

            boolean forward = nums[i] > 0;

            int slow = i;
            int fast = i;

            while (true) {

                slow = next(nums, forward, slow);
                if (slow == -1) break;

                fast = next(nums, forward, fast);
                if (fast == -1) break;

                fast = next(nums, forward, fast);
                if (fast == -1) break;

                if (slow == fast) {

                    // Length must be > 1
                    if (slow == nextIndex(nums, slow))
                        break;

                    return true;
                }
            }
        }

        return false;
    }

    private int next(int[] nums, boolean forward, int current) {

        boolean direction = nums[current] > 0;

        if (direction != forward)
            return -1;

        return nextIndex(nums, current);
    }

    private int nextIndex(int[] nums, int current) {

        int n = nums.length;

        return ((current + nums[current]) % n + n) % n;
    }
}