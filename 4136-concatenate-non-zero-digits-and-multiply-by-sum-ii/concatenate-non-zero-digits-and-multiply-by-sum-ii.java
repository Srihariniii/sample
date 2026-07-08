class Solution {

    static final int MOD = 1000000007;

    public int[] sumAndMultiply(String s, int[][] queries) {

        int n = s.length();

        long[] pow10 = new long[n + 1];
        pow10[0] = 1;

        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        int[] sumD = new int[n + 1];
        long[] preNum = new long[n + 1];
        int[] nonZero = new int[n + 1];

        for (int i = 0; i < n; i++) {

            int digit = s.charAt(i) - '0';

            sumD[i + 1] = sumD[i] + digit;
            preNum[i + 1] = preNum[i];
            nonZero[i + 1] = nonZero[i];

            if (digit != 0) {
                preNum[i + 1] = (preNum[i] * 10 + digit) % MOD;
                nonZero[i + 1]++;
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int l = queries[i][0];
            int r = queries[i][1] + 1;

            int len = nonZero[r] - nonZero[l];

            long x = (preNum[r] - (preNum[l] * pow10[len]) % MOD + MOD) % MOD;

            long sum = sumD[r] - sumD[l];

            ans[i] = (int) ((x * sum) % MOD);
        }

        return ans;
    }
}