class NumMatrix {
    
    int[][] matrix;
    
    int[][] preSum;

    // preSum
                          // 0   0    0   0  0             
    // 1 1 1 1 1           0 1]  2    3]  4  5    
    // 1 1 1 1 1   preSum  0 2  [4    6] .....   
    // 1 1 1 1 1   ----->  0 3] [6    9] .. ..  
    // 1 1 1 1 1           0 4  ...  ..  .. ..  
    // original       preSum[r][c] = preSum[r-1][c] + preSum[r][c-1] + matrix[r][c] - preSum[r-1][c-1]
    // add left top as with defaul zero to handle out of bound issue
    // shif one po    preSum[r+1][c+1] = preSum[r][c+1] + preSum[r+1][c] - preSum[r][c] + matrix[r][c]
    
    // TC: O(n*m) SC: O(n*m)
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        preCalc();
    }
    
    private void preCalc() {
        int rLen = matrix.length;
        int cLen = matrix[0].length;
        
        preSum = new int[rLen + 1][cLen + 1];
        for (int r = 0; r < rLen; r++) {
            for (int c = 0; c < cLen; c++) {
                preSum[r+1][c+1] = preSum[r][c+1] + preSum[r+1][c] - preSum[r][c] + matrix[r][c];
            }
        }
    }


    //             r1 c1     r2 c2
    // query      (1,  1) - (2,  2)
    //            (r2, c2) - (r1-1, c2) - (r2, c1-1) + (r1 -1, c1 -1)
    // shift-->   (r2+1, c2+1) - (r1, c2+1) - (r2+1, c1) + (r1, c1)
    //             9@(2, 2) - 3@(1, 2) - 3@(2, 0) + 1@(0,0) = 4
    // TC: O(1)
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2+1][col2+1] - preSum[row1][col2+1] - preSum[row2+1][col1] + preSum[row1][col1];
    }
    
    
    // TC: (n*m), SC: O(1)
    public int bruteForce(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int r = row1; r <= row2; r++) {
            for (int c = col1; c <= col2; c++) {
                sum += matrix[r][c];
            }
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */