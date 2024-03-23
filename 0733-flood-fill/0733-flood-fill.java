class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        
        if (originalColor == color) return image;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int r = pos[0];
            int c = pos[1];
            
            if (r < 0 || c < 0 || r >= image.length || c >= image[0].length || image[r][c] != originalColor) {
                continue;
            }
            
            
            image[r][c] = color;

            for (int[] dir : directions) {
                q.offer(new int[]{r + dir[0], c + dir[1]});
            }
        }
        
        
        return image;
        
    }
}