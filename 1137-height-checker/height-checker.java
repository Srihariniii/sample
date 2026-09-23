class Solution {
    public int heightChecker(int[] heights) {

        int[] original = new int[heights.length];

        for(int i = 0; i < heights.length; i++) {
            original[i] = heights[i];
        }

        for(int i = 0; i < heights.length; i++) {
            for(int j = i + 1; j < heights.length; j++) {

                if(heights[i] > heights[j]) {
                    int t = heights[i];
                    heights[i] = heights[j];
                    heights[j] = t;
                }
            }
        }

        int c = 0;

        for(int i = 0; i < heights.length; i++) {
            if(original[i] != heights[i]) {
                c++;
            }
        }

        return c;
    }
}