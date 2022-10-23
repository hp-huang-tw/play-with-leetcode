class Solution {
    // TC: O(n^2), SC: O(1)
    public void rotate(int[][] matrix) {
        int l = 0, r = matrix[0].length - 1;
        
        while (l < r) {
            
            for (int i = 0; i < r-l; i++) {
                int top = l, bottom = r;
            
                // save the value of topLeft
                int topLeft = matrix[top][l+i];

                // move bottomLeft to topLeft
                matrix[top][l+i] = matrix[bottom-i][l];

                // move bottomRight to bottomLeft
                matrix[bottom-i][l] = matrix[bottom][r-i];

                // move topRight to bottomRight
                matrix[bottom][r-i] = matrix[top+i][r];

                // move topLeft to topRight
                matrix[top+i][r] = topLeft;
            }
            
            l++;
            r--;
        }
    }
}