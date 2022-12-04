class Solution {
    
    // TC: (m*n)
    // SC: (m*n)
    public int maximalSquare(char[][] matrix) {
        int rowLen = matrix.length; 
        // int cols = rows > 0 ? matrix[0].length : 0; // if 0 <= m, n <= 300
        int colLen = matrix[0].length; // the constraints is 1 <= m, n <= 300
        
        // 1. check if self is 1. 
        // 2. yes. find the min dp value of anti-diagonal, top, left
        // original        dp map
        //                  0 0 0
        // 0 1 1          0 0 1 1
        // 1 1 1      ->  0 1 2 2  max = 2 -> area = max * max
        // 1 0 0          0 1 0 0
        
        // we add an extra all zero column and row outside of the actual dp table
        // to handle out of bound case
        int[][] dp = new int[rowLen + 1][colLen + 1];

        int maxSqLen = 0;
        
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (matrix[i][j] == '1') {
                    // find the min left, top, antiDiag
                    dp[i + 1][j + 1] = 1 + Math.min(Math.min(dp[i + 1][j], dp[i][j + 1]),
                                                    dp[i][j]);
                    maxSqLen = Math.max(maxSqLen, dp[i + 1][j + 1]);
                }
            }
        }
        
        return maxSqLen * maxSqLen;
    }
    
    // TC: O((m*n)^2), SC: O(1)
    public int bruteForce(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int maxsqlen = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    int sqlen = 1;
                    boolean flag = true;
                    while (sqlen + i < rows && sqlen + j < cols && flag) {
                        for (int k = j; k <= sqlen + j; k++) {
                            if (matrix[i + sqlen][k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        for (int k = i; k <= sqlen + i; k++) {
                            if (matrix[k][j + sqlen] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (flag)
                            sqlen++;
                    }
                    if (maxsqlen < sqlen) {
                        maxsqlen = sqlen;
                    }
                }
            }
        }
        return maxsqlen * maxsqlen;
    }
}