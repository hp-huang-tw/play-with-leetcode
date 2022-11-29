class Solution {
            
    private int[][] grid;
    
    private Set<Pair<Integer, Integer>> currentIsland;
    
    private Set<Pair<Integer, Integer>> visited = new HashSet<>();
    
    private int rowLen = 0;
    
    private int colLen = 0;
    
    private int currOriginRow;
    
    private int currOriginCol;
    
    public int numDistinctIslands(int[][] grid) {
        this.grid = grid;
        
        rowLen = grid.length;
        colLen = grid[0].length;
        
        Set<Set<Pair<Integer, Integer>>> islands = new HashSet();
        
        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                currentIsland = new HashSet();
                if (grid[row][col] == 1 && !visited.contains(new Pair(row, col))) {
                    currOriginRow = row;
                    currOriginCol = col;
                    bfs(row, col);
                    
                }
                
                if (!currentIsland.isEmpty()) {
                    islands.add(currentIsland);
                }
            }
        }
        return islands.size();
    }

    // time: O(n x m)
    // space: O(min(n, m))
    private void bfs(int row, int col) {
        Pair<Integer, Integer> currentPosition = new Pair(row, col);
        
        Deque<Pair> q = new LinkedList<Pair>();
        q.add(currentPosition);
        visited.add(currentPosition);
        
        // (0, 0)
        //        (1, 0), (0, 1)
        //                (0, 1) (1, 1)
        // ....
        while (!q.isEmpty()) {
            Pair<Integer, Integer> position = q.pollFirst();  // poollLast() is dfs solution
            
            currentIsland.add(new Pair<>(position.getKey() - currOriginRow, 
                                         position.getValue() - currOriginCol));
            
            int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            
            for (int[] dir : directions) {
                int nextRow = position.getKey() + dir[0];
                int nextCol = position.getValue() + dir[1];
                Pair<Integer, Integer> nextPosition = new Pair(nextRow, nextCol);
                
                // expand current island
                // check not out of bound, not visit yet.
                if (-1 < nextRow && nextRow < rowLen &&  -1 < nextCol && nextCol < colLen 
                   && !visited.contains(nextPosition) 
                    && grid[nextRow][nextCol] == 1) {               
                    q.add(nextPosition);
                    visited.add(nextPosition);
                }
            }
        }
    }
}