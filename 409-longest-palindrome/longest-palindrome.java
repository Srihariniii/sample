class Solution {
    public int longestPalindrome(String s) {
        
        int[] count = new int[128];  // ASCII characters
        
        // Step 1: Count frequency
        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        
        int length = 0;
        boolean hasOdd = false;
        
        // Step 2: Calculate palindrome length
        for(int i = 0; i < 128; i++) {
            
            if(count[i] % 2 == 0) {
                length += count[i];
            } else {
                length += count[i] - 1;
                hasOdd = true;
            }
        }
        
        if(hasOdd == true) {
            length += 1;
        }
        
        return length;
    }
}