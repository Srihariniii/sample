class Solution {
    public int findGCD(int[] nums) {

        int min = nums[0];
        int max = nums[0];

        // Find smallest and largest element
        for (int num : nums) {
            if (num < min)
                min = num;

            if (num > max)
                max = num;
        }

        // Find GCD
        while (max != 0) {
            int temp = max;
            max = min % max;
            min = temp;
        }

        return min;
    }
}