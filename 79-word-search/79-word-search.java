class Solution {
    
    private char[][] board;
    
    private String word;
    
    private Integer rows;
    
    private Integer cols;
    
    private boolean[][] hit;
    
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        rows = board.length;
        cols = board[0].length;
        hit = new boolean[rows][cols];
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (search(r, c, 0)) return true;
            }
        }
        return false;
    }
    
    // time: O(r*c*4^n)
    private boolean search(int r, int c, int indexOfWord) {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        if (indexOfWord >= word.length()) return true;
        
        if (r < 0 || r >= rows || c < 0 || c >= cols || hit[r][c] || 
            board[r][c] != word.charAt(indexOfWord)) return false;
        
        hit[r][c] = true;
        for (int[] dir:directions) {
            if (search(r + dir[0], c + dir[1], indexOfWord + 1)) return true;
        }
        hit[r][c] = false;
        
        return false;
    }
}