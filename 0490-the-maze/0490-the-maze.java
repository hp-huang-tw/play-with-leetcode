class Solution {
    
    private int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    
    private int[][] maze;
    
    private boolean[][] visited;
    // private Set<Pair<Integer, Integer>> visited;
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        this.maze = maze;
        // this.visited = new HashSet<>();
        visited = new boolean[maze.length][maze[0].length];
        //return dfs(new Pair(start[0], start[1]), new Pair(destination[0], destination[1]));
        return dfs(start, destination);
    }
    
    private boolean dfs(int[] start, int[] des) {
        int sX = start[0], sY = start[1];
        
        if (visited[sX][sY]) return false;
        
        if (sX == des[0] && sY == des[1]) return true;
        
        visited[sX][sY] = true;
        
        for (int[] dir : dirs) {
            int x = sX + dir[0];
            int y = sY + dir[1];
            while (0 <= x && x < maze.length && 0 <= y && y < maze[0].length && maze[x][y] == 0) {
                x += dir[0];
                y += dir[1];
            }
            if (dfs(new int[]{ x - dir[0], y - dir[1]}, des)){
                return true;
            }
        }
        
        return false;
    }
    
//     private boolean dfs(Pair<Integer, Integer> start, Pair<Integer, Integer> des) {
        
//         if (visited.contains(start)) return false;
        
//         if (start.getKey() == des.getKey() && des.getValue() == des.getValue()) {
//             return true;
//         }
        
//         visited.add(start);
        
//         for (int[] d : dir) {
//             int x = start.getKey() + d[0];
//             int y = start.getValue() + d[1];
//             while (0 <= x && x < maze.length && 0 <= y && y < maze[0].length && maze[x][y] == 0) {
//                 x += d[0];
//                 y += d[1];
//             }
//             if (dfs(new Pair(x - d[0], y - d[1]), des)) {
//                 return true;
//             }
//         }
//         return false;
//     }
}