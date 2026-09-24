class Solution {
    public int smallestIndex(int[] nums) {

        int s = 0;
        boolean f = false;
        int min = 0;

        for (int i = 0; i < nums.length; i++) {

            s = 0;
            int n = nums[i];

            while (n > 0) {
                int r = n % 10;
                s = s + r;
                n = n / 10;
            }

            if (i == s) {

                if (!f) {
                    min = i;
                    f = true;
                } else {
                    min = Math.min(min, i);
                }
            }
        }

        if (f) {
            return min;
        } else {
            return -1;
        }
    }
}