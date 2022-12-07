class Solution {
    
    private static final int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    
    private static final int EMPTY = Integer.MAX_VALUE;
    
    private static final int GATE = 0;
    
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (rooms[row][col] == GATE) {
                    q.add(new int[] { row, col });
                }
            }
        }
        
        while (!q.isEmpty()) {
            int[] point = q.poll();
            int row = point[0];
            int col = point[1];
            for (int[] dir : dirs) {
                int r = row + dir[0];
                int c = col + dir[1];
                if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] != EMPTY) {
                    continue;
                }
                rooms[r][c] = rooms[row][col] + 1;
                q.add(new int[] { r, c });
            }
        }
    }
    
    /*
        Queue<int[]> q;
    // Set<Pair<Integer, Integer>> visited;
    
    boolean[][] visited;
    
    // Queue<Pair<Integer, Integer>> q;
    private int[][] rooms;
    
    private int rLen;
    
    private int cLen;
    public void wallsAndGates(int[][] rooms) {
        this.rooms = rooms;
        this.rLen = rooms.length;
        this.cLen = rooms[0].length;
        
        // this.visited = new HashSet<>();
        this.visited = new boolean[rLen][cLen];
        
        q = new LinkedList<>();
        
        for (int r = 0; r < rLen; r++) {
            for (int c = 0; c < cLen; c++) {
                if (rooms[r][c] == 0) {
                    // Pair<Integer, Integer> p = new Pair(r, c);
                    q.add(new int[]{r, c});
                    // visited.add(p);
                    visited[r][c] = true;
                }
            }
        }
        
        int dist = 0;
        while (!q.isEmpty()) {
            
            for (int i = 0; i < q.size(); i++) {
                // Pair<Integer, Integer> p = q.poll();
                // rooms[p.getKey()][p.getValue()] = dist;
                
                int[] point = q.poll();
                int r = point[0];
                int c = point[1];
                
                rooms[r][c] = dist;
                
                // move 4 dirs
                for (int[] dir : dirs) {
                    // addRoom(new Pair(p.getKey() + dir[0], p.getValue() + dir[1]));
                    // addRoom(r + dir[0], c + dir[1]);
                    int r1 = r + dir[0];
                    int c1 = c + dir[1];
                    if (r1 < 0 || r1 == rLen || c1 < 0 || c1 < cLen || 
                        visited[r1][c1] || rooms[r1][c1] == -1 || rooms[r1][c1] == 0) {
                        continue;
                    }
                    rooms[r1][c1] = rooms[r1][c1] + 1;
                    visited[r1][c1] = true;
                    q.add(new int[] {r1, c1});
                }
            }
            // dist += 1;
        }
    }
    */
    /*
    private void addRoom(int r, int c) {
        // int r = p.getKey(), c = p.getValue();
        // if (r < 0 || r == rLen || c < 0 || c < cLen || 
        //    visited.contains(p) || rooms[r][c] == -1)
        //     return;
        // visited.add(p);
        // q.offer(p);
        if (r < 0 || r == rLen || c < 0 || c < cLen || visited[r][c] || rooms[r][c] == -1) {
            return;
        }
        
        visited[r][c] = true;
        q.offer(new int[] {r, c});
    }*/
}