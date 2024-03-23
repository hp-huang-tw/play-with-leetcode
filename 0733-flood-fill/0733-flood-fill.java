class Solution {
		// top, down, left, right
		int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        
        if (originalColor != color) {
	        helper(image, sr, sc, color, originalColor);
        }
        
        return image;
    }
    
    private void helper(int [][] image, int r, int c, int color, int originalColor) {
	    if (r < 0 || c < 0 || r >= image.length || c >= image[0].length || image[r][c] != originalColor) {
		    return;
	    }
	    
	    image[r][c] = color;
	    
	    for (int[] dir : directions) {
		    helper(image, r + dir[0], c + dir[1], color, originalColor);
	    }
    }
}