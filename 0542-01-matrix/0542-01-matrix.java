class Solution {
    
    private final static int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        
        int[][] distances = new int[m][n];
        boolean[][] seen = new boolean[m][n];
        
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new int[] { i, j });
                    seen[i][j] = true;
                }
            }
        }
        
        int distance = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            
            // handle all nodes at current level
            for (int i = 0; i < size; i++) {
                int[] cell = q.poll();
                int r = cell[0];
                int c = cell[1];
                distances[r][c] = distance;

                for (int[] dir : directions) {
                    int nextRow = r + dir[0];
                    int nextCol = c + dir[1];

                    // push all nodes at next level
                    if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && !seen[nextRow][nextCol]) {
                        q.offer(new int[]{ nextRow, nextCol });
                        seen[nextRow][nextCol] = true;
                    }
                }
            }
            
            distance++;
        }
        
        return distances;
    }
}