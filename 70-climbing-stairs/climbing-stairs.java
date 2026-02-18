class Solution {
    public int climbStairs(int n) {
        int a=0, b=0, c=0;
        if(n<=2){
            return n;
        }
        else{
            a = 1;
            b = 2;
            for(int i=3;i<=n;i++){
                c = a + b;
                a = b;
                b = c;
            }
        }
        return c;
    }
}