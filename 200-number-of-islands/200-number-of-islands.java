class Solution {
    
    private char[][] grid;
    
    private int numOfIslands=0;
    
    private HashSet<Pair> visited = new HashSet<Pair>();
    
    private int rowLen = 0;
    
    private int colLen = 0;
    
    public int numIslands(char[][] grid) {
        this.grid = grid;
        
        rowLen = grid.length;
        colLen = grid[0].length;
        
        for (int row=0; row < rowLen; row++) {
            for (int col=0; col < colLen; col++) {
                if (grid[row][col] == '1' && !visited.contains(new Pair(row, col))) {
                    bfs(row, col);
                    numOfIslands++;
                }
            }
        }
        return numOfIslands;
    }

    // time: O(n x m)
    // space: O(min(n, m))
    private void bfs(int row, int col) {
        Pair<Integer, Integer> currentPosition = new Pair(row, col);
        
        Deque<Pair> q = new LinkedList<Pair>();
        q.add(currentPosition);
        visited.add(currentPosition);
        
        while (!q.isEmpty()) {
            Pair<Integer, Integer> position = q.pollFirst();  // poollLast() is dfs solution
            
            List<Pair<Integer, Integer>> directions = 
                List.of(new Pair(1, 0), new Pair(-1, 0), new Pair(0, 1), new Pair(0, -1));
            
            
            for (Pair<Integer, Integer> direction : directions) {
                int nextRow = position.getKey() + direction.getKey();
                int nextCol = position.getValue() + direction.getValue();
                Pair<Integer, Integer> nextPosition = new Pair(nextRow, nextCol);
                
                // expand current island
                // check not out of bound, not visit yet.
                if (-1 < nextRow && nextRow < rowLen &&  -1 < nextCol && nextCol < colLen 
                   && !visited.contains(nextPosition) 
                    && grid[nextRow][nextCol] == '1') {               
                    q.add(nextPosition);
                    visited.add(nextPosition);
                }
            }
        }
    }
}