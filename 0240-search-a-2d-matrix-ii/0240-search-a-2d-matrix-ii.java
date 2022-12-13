class Solution {
    /*                  m.  n 
    // mxn searchRange(rowLen - 1, colLen - 1)
    //      r      sm
    [[1, 4, 7, 11,15],  if (matrix[r][c] > target) { m = r - 1 }
     [2, 5, 8, 12,19],
     [3, 6, 9, 16,22],
     [10,13,14,17,24],
     [18,21,23,26,30]]
    
    */
    
    // similar with https://leetcode.com/problems/search-a-2d-matrix/
    // bottom-up left-right
    // if (value > target) move top
    // if (value < target) move right
    // else return true;
    // TC: O(r+c), O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        
        int r = rowLen - 1, c = 0;
        while (r > -1 && c < colLen) {
            int value = matrix[r][c];
            if (value > target) {
                r--;
            } else if (value < target) {
                c++;
            } else {
                return true;
            }
        }
        
        return false;
    }
}