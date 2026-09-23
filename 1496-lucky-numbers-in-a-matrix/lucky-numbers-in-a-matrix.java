class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++) {
            int min = matrix[i][0];
            int col = 0;
            for(int j = 1; j < matrix[i].length; j++) {
                if(matrix[i][j] < min) {
                    min = matrix[i][j];
                    col = j;
                }
            }
            boolean max = true;
            for(int k = 0; k < matrix.length; k++) {
                if(matrix[k][col] > min) {
                    max = false;
                    break;
                }
            }
            if(max) {
                list.add(min);
            }
        }
        return list;
    }
}