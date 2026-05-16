class NumMatrix {

    private int[][] prefixSum;


    public NumMatrix(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        prefixSum = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            prefixSum[row][0] = matrix[row][0];
            for (int col = 1; col < cols; col++) {
                prefixSum[row][col] = prefixSum[row][col - 1] + matrix[row][col];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        for (int row = row1; row <= row2; row++) {
            if (col1 > 0) {
                res += prefixSum[row][col2] - prefixSum[row][col1 - 1];
            } else {
                res += prefixSum[row][col2];
            }
        }
        return res;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */

 /**

3, 0, 1, 4, 2
5, 6, 3, 2, 1
1, 2, 0, 1, 5
4, 1, 0, 1, 7
1, 0, 3, 0, 5

(2,1) (4,3) --> 





 */