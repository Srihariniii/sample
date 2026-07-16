import java.util.Arrays;

class Solution {

    public long gcdSum(int[] nums) {

        int[] pr = new int[nums.length];
        int max = 0;

        // Construct prefixGcd array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }

            pr[i] = gcd(nums[i], max);
        }

        // Sort the prefixGcd array
        Arrays.sort(pr);

        int i = 0;
        int j = nums.length - 1;
        long sum = 0;

        // Pair smallest with largest
        while (i < j) {
            sum += gcd(pr[i], pr[j]);
            i++;
            j--;
        }

        return sum;
    }

    // Euclid's Algorithm
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}