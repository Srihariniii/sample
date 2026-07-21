class Solution {
    public int maxActiveSectionsAfterTrade(String s) {

        int ans = 0;
        int preZero = Integer.MIN_VALUE;
        int maxGain = 0;

        int i = 0;
        int n = s.length();

        while (i < n) {

            int j = i;

            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
            }

            int len = j - i;

            if (s.charAt(i) == '1') {
                ans += len;
            } else {
                maxGain = Math.max(maxGain, preZero + len);
                preZero = len;
            }

            i = j;
        }

        return ans + maxGain;
    }
}