class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        
        if (originalColor == color) return image;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        
        while (!q.isEmpty()) {
            int[] currentPosition = q.poll();
            int r = currentPosition[0];
            int c = currentPosition[1];
            
            image[r][c] = color;

            for (int[] dir : directions) {
                int newRow = r + dir[0];
                int newCol = c + dir[1];
                if (newRow >= 0 && newCol >= 0 && newRow < image.length && newCol < image[0].length && image[newRow][newCol] == originalColor) {
                q.offer(new int[]{newRow, newCol});
            }
                
            }
        }
        
        
        return image;
        
    }
}