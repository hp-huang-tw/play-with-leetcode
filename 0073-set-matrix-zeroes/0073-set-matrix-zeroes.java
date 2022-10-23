class Solution {
    // TC = (O^2), SP = O(1)
    public void setZeroes(int[][] matrix) {
        int rowLen = matrix.length, colLen = matrix[0].length;
        boolean rowZero = false; // first row should be set as zero or not.
        
        // determine which rows/colos need to set as zero
        // mark the col of first row, the row of first col as 0. if hit 0 at location i,j
        for (int i=0; i < rowLen; i++) {
            for (int j=0; j < colLen; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    
                    // avoid overlap at location 0, 0
                    if (i > 0) {
                        matrix[i][0] = 0;
                    } else {
                        rowZero = true;
                    }
                    
                }
            }
        }
        
        // start set as zero by location (0, 1-n) and (1-m, 0)
        for (int i=1; i < rowLen; i++) {
            for (int j=1; j < colLen; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        // set first col as zero by location 0, 0
        if (matrix[0][0] == 0) {
            for (int i=1; i < rowLen; i++) {
                matrix[i][0] = 0;
            }
        }
        
        // set first row as zero by row zero
        if (rowZero) {
            for (int j=0; j < colLen; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}