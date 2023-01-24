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
        int row = n -  1 - (label - 1)/n;
        int col = ((label - 1)/n % 2) == 0 ? (label - 1) % n : n - 1 - (label - 1) % n;
        return new int[]{ row, col };
    }
}