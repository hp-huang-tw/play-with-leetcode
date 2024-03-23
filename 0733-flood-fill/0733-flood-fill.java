class Solution {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        
        // No need to flood fill if the new color is the same as the original color
        if (originalColor == color) return image;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        
        while (!q.isEmpty()) {
            int[] currentPosition = q.poll();
            int r = currentPosition[0];
            int c = currentPosition[1];
            
            // Fill the current cell with the new color
	        image[r][c] = color; 
            

			// Explore neighbors in all four directions
            for (int[] dir : DIRECTIONS) {
                int newRow = r + dir[0];
                int newCol = c + dir[1];
                
                if (newRow >= 0 && newCol >= 0 && newRow < image.length && newCol < image[0].length && image[newRow][newCol] == originalColor) {
                    // Add neighboring cell to the queue for processing
                    q.offer(new int[]{newRow, newCol});
                }
            }
        }

        return image;        
    }
}