class Solution {
    public int[] buildArray(int[] nums) {
        int ans[]=new int [nums.length];
        
        for(int i=0;i<nums.length;i++){
          int n=nums[i];
          ans[i]=nums[n];
        }
        return ans;
    }
}