class Solution {
    /*
    [["5","3",".",".","7",".",".",".","."]
    ,["6",".",".","1","9","5",".",".","."]
    ,[".","9","8",".",".",".",".","6","."]
    ,["8",".",".",".","6",".",".",".","3"]
    ,["4",".",".","8",".","3",".",".","1"]
    ,["7",".",".",".","2",".",".",".","6"]
    ,[".","6",".",".",".",".","2","8","."]
    ,[".",".",".","4","1","9",".",".","5"]
    ,[".",".",".",".","8",".",".","7","9"]]
             r = 0
    3 3 3   0, 0 (0-2, 0-2) | 0, 1 (0-2, 3-5) | 0, 2 (0-2, 6-8)
    3 3 3   1, 0 (3-5, 0-2) | 1, 1 (3-5, 3-5) | 1, 2 (3-5, 6-8)
    3 3 3   2, 0 (6-8, 0-2) | 2, 1 (6-8, 3-5) | 2, 2 (6-8, 6-8)
    */
    
    // TC: O(n^2), SC: O(n^2)
    public boolean isValidSudoku(char[][] board) {
        int n = 9;
        
        HashSet<Character>[] rows = new HashSet[n];
        HashSet<Character>[] cols  = new HashSet[n];
        HashSet<Character>[] boxes = new HashSet[n];
        
        for (int i = 0; i < n; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
            
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                char val = board[r][c];
                
                if (val == '.') continue;
                
                // check rows
                if (rows[r].contains(val)) {
                    return false;
                }
                
                rows[r].add(val);
                
                // check cols
                if (cols[c].contains(val)) {
                    return false;
                }
                cols[c].add(val);
                
                
                // check boxes
                // r/3 012(0) 345(1) 678 (2)   0+0     0+1     0+2
                // c/3 012(0) 345(1) 678 (2)   1*3+0   1*3+1   1*3+2 
                //                             2*3+0   2*3+1   2*3+2
                int boxIdx = (r / 3) * 3 + (c / 3);
                if (boxes[boxIdx].contains(val)) {
                    return false;
                }
                
                boxes[boxIdx].add(val);
            }
        }
        
        return true;
    }
}