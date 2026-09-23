class Solution {
    public long findTheArrayConcVal(int[] nums) {

        long sum = 0;
        int i = 0;
        int j = nums.length - 1;

        while(i < j) {

            int last = nums[j];

            int temp = last;
            int digits = 0;

            while(temp > 0) {
                digits++;
                temp = temp / 10;
            }

            int power = 1;

            for(int k = 0; k < digits; k++) {
                power = power * 10;
            }

            long value = (long)nums[i] * power + nums[j];

            sum = sum + value;

            i++;
            j--;
        }

        if(i == j) {
            sum = sum + nums[i];
        }

        return sum;
    }
}