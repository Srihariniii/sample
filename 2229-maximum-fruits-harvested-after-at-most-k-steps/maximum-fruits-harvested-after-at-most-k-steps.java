class Solution {

    public int maxTotalFruits(int[][] fruits, int startPos, int k) {

        int n = fruits.length;

        int[] pos = new int[n];
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            pos[i] = fruits[i][0];
            prefix[i + 1] = prefix[i] + fruits[i][1];
        }

        int ans = 0;

        // Go left first
        for (int x = 0; x <= k; x++) {

            int leftPos = startPos - x;

            int remain = k - 2 * x;
            if (remain < 0)
                remain = (k - x) / 2;

            int rightPos = startPos + remain;

            int left = lowerBound(pos, leftPos);
            int right = upperBound(pos, rightPos) - 1;

            if (left <= right)
                ans = Math.max(ans, prefix[right + 1] - prefix[left]);
        }

        // Go right first
        for (int x = 0; x <= k; x++) {

            int rightPos = startPos + x;

            int remain = k - 2 * x;
            if (remain < 0)
                remain = (k - x) / 2;

            int leftPos = startPos - remain;

            int left = lowerBound(pos, leftPos);
            int right = upperBound(pos, rightPos) - 1;

            if (left <= right)
                ans = Math.max(ans, prefix[right + 1] - prefix[left]);
        }

        return ans;
    }

    private int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] >= target)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    private int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] > target)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}