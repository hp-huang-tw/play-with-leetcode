class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int sColor = image[sr][sc];
        
        if (sColor != color) {
            helper(image, sr, sc, color, sColor);
        }
        return image;
    }
    
    private void helper(int[][] image, int r, int c, int color, int sColor) {
        if (r < 0 || c < 0 || r >= image.length || c >= image[0].length || image[r][c] != sColor) 
            return;
        
        image[r][c] = color;
        
        int[][] dirs = new int[][] {
            {-1, 0}, {1 , 0}, {0, -1}, {0, 1}
        };
        
        for (int[] dir : dirs) {
            helper(image, r + dir[0], c + dir[1], color, sColor);
        }
    }
}


// [1,1,1],
// [1,1,0],
// [1,0,1]


// [2,2,2],
// [2,2,0],
// [2,0,1]


// [2,2,2],
// [2,2,0],
// [2,0,1]