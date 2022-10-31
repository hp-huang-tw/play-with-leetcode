class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        int l = 0, r = matrix[0].length;
        int t = 0, b = matrix.length;
        
        while (l < r && t < b) {
            // go through top row from left to right
            for (int i = l; i < r; i++) {
                res.add(matrix[t][i]);
            }
            t++;
            
            // go through right column from top to down
            for (int i = t; i < b; i++) {
                res.add(matrix[i][r-1]);
            }
            r--;
            
            if (!(l < r && t < b)) {
                break;
            }
            
            // go through botton row from right to left
            for (int i = r - 1; i > l - 1; i--) {
                res.add(matrix[b-1][i]);
            }
            b--;
            
            // go through left column from down to top
            for (int i = b - 1; i > t - 1; i--) {
                res.add(matrix[i][l]);
            }
            l++;
        }
        
        return res;
    }
}