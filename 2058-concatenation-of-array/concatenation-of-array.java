class Solution {
    public int[] getConcatenation(int[] nums) {
        int n=nums.length;
        int s=0;
        int ans[]=new int[n*2];
        for(int i=0;i<n;i++){
            ans[i]=nums[i];
           s=i;
        }
        int j=0;
        while(n>0){
            ans[s+1]=nums[j];
            s++;
            j++;
            n--;
        }
        return ans;
    }
}