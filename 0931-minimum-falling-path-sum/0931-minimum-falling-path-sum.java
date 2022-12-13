class Solution {
    // ---->
    // 1 2 3
    // 3 4 5
    // 4 5 6
    
    //      1                             2                            3
    //.     |       \               /     |       \             /      |
    //      3       4              3       4        5          4       5
    //     / \    / | \           / \    / | \     / |       / | \    / |
    //    4   5  4. 5  6         4   5  4. 5  6   5  6      4  5  6  5  6
    //                         (repeat work -> dp cache)
    
    // TC: O(n^2). SC: O(n^2)
    public int minFallingPathSum(int[][] matrix) {
        int res = Integer.MAX_VALUE;
        int n = matrix.length;
        
        Integer[][] cache = new Integer[n][n];
        
        for (int col = 0; col < n; col++) {                     // choose 1, 2, 3
            res = Math.min(res, findMinFallingPathSum(matrix, 0, col, cache));
        }
        
        return res;
    }
    
    private int findMinFallingPathSum(int[][] matrix, int r, int c, Integer[][] cache) {
        // base case
        if (c < 0 || c > matrix[0].length -1) {
            return Integer.MAX_VALUE;
        }
        
        // reach last row
        if (r == matrix.length - 1) {
            return matrix[r][c];
        }
        
        // have calculted
        if (cache[r][c] != null) {  // O(2^n) -> O(n^2)
            return cache[r][c];
        }
        
        int left = findMinFallingPathSum(matrix, r + 1, c - 1, cache);
        int mid = findMinFallingPathSum(matrix, r + 1, c, cache);
        int right = findMinFallingPathSum(matrix, r + 1, c + 1, cache);
        
        cache[r][c] = matrix[r][c] + Math.min(Math.min(left, mid), right);
        return cache[r][c];
    }
}