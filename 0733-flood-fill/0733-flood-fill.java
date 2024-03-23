class Solution {
		// Define directions: top, bottom, left, right
		int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // Define the target color `originalColor` at the source point (sr, sc). 
		    // This is the color of the region we want to flood fill.
        int originalColor = image[sr][sc];
        
        // Check if the color at the source point is already the new color
        if (originalColor != color) {
	        helper(image, sr, sc, color, originalColor);
        }
        
        return image;
    }
    
    private void helper(int [][] image, int r, int c, int color, int originalColor) {
	    // Check if the current element is out of bounds or already changed
	    if (r < 0 || c < 0 || r >= image.length || c >= image[0].length || image[r][c] != originalColor) {
		    return;
	    }
	    
	    // Set the current element to the new color
	    image[r][c] = color;
	    
	    // Recursively call floodFillHelper on neighboring elements
	    for (int[] dir : directions) {
		    helper(image, r + dir[0], c + dir[1], color, originalColor);
	    }
    }
}