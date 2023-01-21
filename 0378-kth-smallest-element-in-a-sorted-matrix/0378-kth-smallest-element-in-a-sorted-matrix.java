class Solution {

    /*
    [[1,5,9],
     [10,11,13],
     [12,13,15]]

     k=8
     
     ---------------------
     binary search + couting
     
     L-R=       1-15               9-15                13-15 
     mid =         8                 12                   14
     count =    2 [1,5]            6[1,5,9,10,11,12]   8    
     max =      5                  12                  13
    */
    
    // TC: O(n^2 * log(n^2))
    // SC: O(1)
    
    public int kthSmallest2(int[][] matrix, int k) {
        int rows = matrix.length, cols = matrix[0].length;
        
        int lo = matrix[0][0], hi = matrix[rows - 1][cols - 1] ;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0,  maxNum = lo;
           
            for (int r = 0, c = cols - 1; r < rows; r++) {
                while (c >= 0 && matrix[r][c] > mid) c--;   
                
                if (c >= 0) {
                    count += (c + 1); // count of nums <= mid in matrix
                    maxNum = Math.max(maxNum, matrix[r][c]); 
         // mid might be value not in  matrix, we need to record the actually max num;
                } else { //it means c < 0
                    break;
                } 
            }
            
            // adjust search range
            if (count == k) return maxNum;
            else if (count < k) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;
    }
    
    /*
    [[1,1,3,8,13],
     [4,4,4,8,18],
     [9,14,18,19,20],
     [14,19,23,25,25],
     [18,21,26,28,29]]
     13
    */
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int l = matrix[0][0], r = matrix[n-1][n-1];
        
        while (l <= r) {
            int mid = (l+r)/2;
            
            // count of numbers which is less and equal to mid
            int count = 0;
            int max = Integer.MIN_VALUE;    // the max value of numbers which is less and equal to mid
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] <= mid) {
                        count++;
                        max = Math.max(max, matrix[i][j]);
                    } else {
                        break;
                    }
                }
            }
            
            if (count == k) return max;
            
            // update l & r
            if (count < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        
        return l;
    }
    
}