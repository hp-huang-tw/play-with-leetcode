class Solution {
    /*  r\c _______            l                         r
           |1 2 3 4            0                         (m*n)-1
           |5 6 7 8  ------>   1 2 3 4 | 5 6 7 8 | 9 1 1 2
           |9 1 1 2                                  ^            
              ^ mid = (l + r) / 2
            matrix[mid/c][mid%c]
    */
    // TC: o(log(mn)). SC: O(1)
    public boolean searchMatrix_binary(int[][] matrix, int target) {
        int rowLen = matrix.length;
        if (rowLen == 0) return false;
        
        int colLen = matrix[0].length;
        int l = 0, r = rowLen * colLen -1;
        
        while (l <= r) {
            int mid = (l + r)/2;
            int curr = matrix[mid / colLen][mid % colLen];
            
            if (target == curr) {
                return true;
            } else if (target < curr) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }
    
    // TC: O(r+c), O(1) searchMatrix II
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