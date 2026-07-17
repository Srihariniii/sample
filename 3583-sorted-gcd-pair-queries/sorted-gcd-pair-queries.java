class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {

        int max = 0;
        for (int x : nums)
            max = Math.max(max, x);

        int[] freq = new int[max + 1];

        for (int x : nums)
            freq[x]++;

        int[] cnt = new int[max + 1];

        // count numbers divisible by i
        for (int i = 1; i <= max; i++) {
            for (int j = i; j <= max; j += i) {
                cnt[i] += freq[j];
            }
        }

        long[] gcdCount = new long[max + 1];

        // Inclusion-Exclusion
        for (int i = max; i >= 1; i--) {

            long pairs = (long) cnt[i] * (cnt[i] - 1) / 2;

            gcdCount[i] = pairs;

            for (int j = i * 2; j <= max; j += i) {
                gcdCount[i] -= gcdCount[j];
            }
        }

        long[] prefix = new long[max + 1];

        for (int i = 1; i <= max; i++) {
            prefix[i] = prefix[i - 1] + gcdCount[i];
        }

        int[] ans = new int[queries.length];

        for (int k = 0; k < queries.length; k++) {

            long target = queries[k] + 1;

            int l = 1;
            int r = max;

            while (l < r) {

                int mid = l + (r - l) / 2;

                if (prefix[mid] >= target)
                    r = mid;
                else
                    l = mid + 1;
            }

            ans[k] = l;
        }

        return ans;
    }
}