class Solution {
    // live(1): 2-3 live (1) -> 3 or die (0) -> 1
    // die(0):  3 live (1) -> 2 or die (0) -> 0
    /* original |. new  |. state
          0         0        0
          1.        0        1      v
          0         1        2      v
          1         1        3
    */
    public void gameOfLife(int[][] board) {
        int rLen = board.length;
        int cLen = board[0].length;
        
        // mark its state
        for (int r = 0; r < rLen; r++) {
            for (int c = 0; c < cLen; c++) {
                int countNeis = countNeighbors(board, r, c);
                
                // check original value
                if (board[r][c] == 1) {
                    if (countNeis == 2 || countNeis == 3) {
                        board[r][c] = 3;
                    }
                } else if (board[r][c] == 0) {
                    if (countNeis == 3) {
                        board[r][c] = 2;
                    }
                }
            }
        }
        
        // covert to new value
        for (int r = 0; r < rLen; r++) {
            for (int c = 0; c < cLen; c++) {
                // check original value
                if (board[r][c] == 1) {
                    board[r][c] = 0;
                } else if (board[r][c] == 2 || board[r][c] == 3) {
                    board[r][c] = 1;
                }
            }
        }
    }
    
    private int countNeighbors(int[][] board, int r, int c) {
        int count = 0;
        
        for (int i = r - 1; i < r + 2; i++) {
            for (int j = c - 1; j < c + 2; j++) {
                // skip itself and check out of bound
                if ((i==r && j == c) || i < 0 || i >= board.length
                    || j < 0 || j >= board[0].length) {
                    continue;
                }
                
                if (board[i][j] == 1 || board[i][j] == 3) {
                    count++;
                }
            }
        }
        
        return count;
    }
}