class Solution {
    public int lengthOfLongestSubstring(String s) {
        int r = 0; // longest substring length
        
        // Outer loop: start position of substring
        for (int i = 0; i < s.length(); i++) {
            int count = 1; // at least one character (s[i])
            
            // Inner loop: move forward from i+1
            for (int j = i + 1; j < s.length(); j++) {
                boolean repeated = false; // check if s[j] already appeared
                
                // Check all characters from i to j-1
                for (int k = i; k < j; k++) {
                    if (s.charAt(k) == s.charAt(j)) {
                        repeated = true;
                        break;
                    }
                }
                
                if (repeated) {
                    break; // stop when repeat found
                } else {
                    count++;
                }
            }
            
            // Update the longest length
            if (count > r) {
                r = count;
            }

            // print iteration info
            System.out.println("i = " + i + " → count = " + count + ", r = " + r);
        }
        
        return r;
    }
}

