class Solution {
    
    private int[][] heights;
    
    private int rowLen=0;
    
    private int colLen=0;
    
    // time: o(m*n)
    // space: o(m*n)
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        rowLen = heights.length;
        colLen = heights[0].length;
        
        // the position which the water can flow into pacific/atlantic
        //HashSet<Position> pacific = new HashSet<Position>();
        //HashSet<Position> altantic = new HashSet<Position>();
        boolean[][] pacific = new boolean[rowLen][colLen];
        boolean[][] altantic = new boolean[rowLen][colLen];
        
        // traverse from first row and last row
        for (int col = 0; col < colLen; col++) {
            dfs(0, col, pacific, heights[0][col]);
            //System.out.println("done pacific row");
            dfs(rowLen-1, col, altantic, heights[rowLen-1][col]);
            //System.out.println("done altantic row");
        }
        
       // System.out.println("done row");
        // traverse from first col and last col
        for (int row = 0; row < rowLen; row++) {
            dfs(row, 0, pacific, heights[row][0]);
            //System.out.println("done pacific col");
            dfs(row, colLen -1, altantic, heights[row][colLen -1]);
            //System.out.println("done altantic col");
        }
        
        //System.out.println("done col");
        
        // find the position which the water can flow to both Pacific and Atlantic
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        /*
        for (Position p: pacific) {
            if (altantic.contains(p)) {
                res.add(List.of(p.getRow(), p.getCol()));
            }
            String s = String.format("(%d, %d)", p.getRow(), p.getCol());
            System.out.println(s);
        }*/
        
        for (int row=0; row < rowLen; row++) {
            for (int col=0; col < colLen; col++) {
                if (pacific[row][col] && altantic[row][col]) {
                    res.add(List.of(row, col));
                }
            }
        }
        
        return res;
    }
    
    private void dfs(int row, int col, boolean[][] ocean, int prevHeight) {
        // Position currentPosition = new Position(row, col);
        
        if (row < 0 || row >= rowLen || col < 0 || col >= colLen
            || ocean[row][col] || heights[row][col] < prevHeight) {
            return;
        }
        
        int currentHeghts = heights[row][col];
        
        //System.out.println("add");
        ocean[row][col] = true;
        
        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        for (int[] dir : directions) {
             dfs(row + dir[0], col + dir[1], ocean, currentHeghts);
        }
    }
}

/*
class Position {
    private int row;
    
    private int col;
    
    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }
    
    public int getRow() {
        return row;
    }
    
    public int getCol() {
        return col;
    }
}
*/