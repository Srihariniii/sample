class Solution {
    public int numSquares(int n) {
        
        while (n % 4 == 0) {
            n /= 4;
        }

 
        if (n % 8 == 7) {
            return 4;
        }

        
        if (isPerfectSquare(n)) {
            return 1;
        }

        
        for (int i = 1; i * i <= n; i++) {
            int remainder = n - i * i;
            if (isPerfectSquare(remainder)) {
                return 2;
            }
        }

        
        return 3;
    }

    private boolean isPerfectSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
}