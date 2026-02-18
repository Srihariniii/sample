class Solution {
    public int findNthDigit(int n) {
        long k = n;
        long i = 1;
        long q = 1;

        while (k > q * 9L * i) {
            k -= q * 9L * i;
            i *= 10;
            q++;
        }

        k--;
        long x = k / q;
        String curr = String.valueOf(i + x);
        long m = k % q;

        return curr.charAt((int)m) - '0';
    }
}