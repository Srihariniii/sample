class Solution {
    public int numSquares(int n) {
        // Step 1: Remove powers of 4 (4^a * (8b + 7) form)
        while (n % 4 == 0) {
            n /= 4;
        }

        // Step 2: If n % 8 == 7, then needs 4 squares
        if (n % 8 == 7) {
            return 4;
        }

        // Step 3: Check if n is a perfect square
        if (isPerfectSquare(n)) {
            return 1;
        }

        // Step 4: Check if it can be written as a sum of 2 perfect squares
        for (int i = 1; i * i <= n; i++) {
            int remainder = n - i * i;
            if (isPerfectSquare(remainder)) {
                return 2;
            }
        }

        // Step 5: If none of the above, it needs 3 squares
        return 3;
    }

    private boolean isPerfectSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
}