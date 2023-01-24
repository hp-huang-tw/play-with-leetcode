class Solution {

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
         
        Deque<int[]> q = new LinkedList<>(); 
        q.add(new int[]{ 1, 0 });   // [label, moves]
        
        Set<Integer> visited = new HashSet<>();
        visited.add(1);
        
        while (!q.isEmpty()) {
            int[] labelAndMoves = q.pollFirst();
            int label = labelAndMoves[0];
            int moves = labelAndMoves[1];
            
            for (int i = 1; i < 7; i++) {
                int nextLabel = label + i;
                int[] nextPosition = getPosition(nextLabel, board);
                
                if (board[nextPosition[0]][nextPosition[1]] != -1) {
                    nextLabel = board[nextPosition[0]][nextPosition[1]];
                }
                
                if (nextLabel == n * n) {
                    return moves + 1;
                }
                
                if (!visited.contains(nextLabel)) {
                    visited.add(nextLabel);
                    q.add(new int[]{ nextLabel, moves + 1 });
                }
            }
        }
        
        return -1;
        
    }
    
    /// the most important part
    private int[] getPosition(int label, int[][] board) {        
        int n = board.length;
        int row = n - 1 - (label - 1)/n;
        int col = ((label - 1)/n % 2) == 0 ? (label - 1) % n : n - 1 - (label - 1) % n;
        return new int[]{ row, col };
    }
    
    /*
    n = 6
                 0  1. 2. 3. 4. 5        (label - 1)/n = x
    0          [36,35,34,33,32,31]             5
    1          ...................             4
    2          ...................             3
    3          ...................             2
    4          [12,11,10,09,08,07]             1
    5          [01,02,03,04,05,06]             0 <- n-x-1 
    
     odd col:  (label - 1) % n
     even col: n - 1 - (label - 1) % n 
    */
}