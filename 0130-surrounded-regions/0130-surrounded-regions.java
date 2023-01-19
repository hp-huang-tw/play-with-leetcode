class Solution {
    
    char[][] board;
    
    int rowLen;
    
    int colLen;
        
    int[][] directions = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    // TC: O(m*n). SC: O(1)
    public void solve(char[][] board) {
        this.board = board;
        rowLen = board.length;
        colLen = board[0].length;
        
        // 1. find the unsurrounded regions
        for (int r = 0; r < rowLen; r++) {
            for (int c = 0; c < colLen; c++) {
                if ((r == 0 || r == rowLen - 1 || c == 0 || c == colLen -1) &&
                    board[r][c] == 'O') {
                    captureUnsurroundedRegions(r, c);
                }
            }
        }
        
        // 2. flip O as X, flip # as X
        for (int r = 0; r < rowLen; r++) {
            for (int c = 0; c < colLen; c++) {
                if (board[r][c] == 'O') board[r][c] = 'X';
                if (board[r][c] == '#') board[r][c] = 'O';
            }
        }
    }
    
    private void captureUnsurroundedRegions(int r, int c) {
        if (r < 0 || r == rowLen || c < 0 || c == colLen ||
           board[r][c] != 'O') {
            return;
        }
        
        board[r][c] = '#';
        for (int[] dir : directions) {
            captureUnsurroundedRegions(r + dir[0], c + dir[1]);
        }
    }
}