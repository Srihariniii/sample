class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{first(nums, target), last(nums, target)};
    }

    private int first(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int ans = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] >= target)
                r = mid - 1;
            else
                l = mid + 1;

            if (nums[mid] == target)
                ans = mid;
        }

        return ans;
    }

    private int last(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int ans = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] <= target)
                l = mid + 1;
            else
                r = mid - 1;

            if (nums[mid] == target)
                ans = mid;
        }

        return ans;
    }
}