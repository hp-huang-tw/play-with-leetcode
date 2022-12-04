class Solution {
    
    private static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    private int rowLen;
    
    private int colLen;
    
    private int[][] matrix;
    
    private HashMap<Pair<Integer, Integer>, Integer> lipMap = new HashMap<>();
    
    // DFS with memoization
    // LIP map   key   value
    //         ((r, c), lis)
    //
    //               Math.max(4->9, 4->8)=> 1+1, 1+0 = 2  
    //  9 9 4        1 1 2                  1 1 2         1 1 2   
    //  6 6 8  --->      1            --->  2   1   --->  2 2 1   -> max(LIS) = 4
    //  2 1 1                                             3 4 2
    
    // TC: O(m*n)
    // SC: O(m*n)
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        this.matrix = matrix;
        rowLen = matrix.length;
        colLen = matrix[0].length;
        
        int maxLIP = 0;
        for (int r = 0; r < rowLen; r++) {
            for (int c = 0; c < colLen; c++) {
                maxLIP = Math.max(maxLIP, dfs(r, c, -1));
            }
        }
        
        return maxLIP;
    }
    
    private int dfs(int r, int c, int prevValue) {
        // if out of bound
        if (r < 0 || r == rowLen || c < 0 || c == colLen) {
            return 0;
        }
        
        // curValue must be larger than prev
        int currValue = matrix[r][c];
        if (currValue <= prevValue) {
            return 0;
        }
        
        // load from cache
        Pair<Integer, Integer> curPosition = new Pair(r, c);
        if (lipMap.containsKey(curPosition)) {
            return lipMap.get(curPosition);
        }
        
        // recursive four directions
        int maxLen = 1; // default len for itself
        for (int[] dir : directions) {
            maxLen = Math.max(maxLen, 1 + dfs(r + dir[0], c + dir[1], currValue));
        }
        
        lipMap.put(curPosition, maxLen);
        
        return maxLen;
    }
    
    // Naive DFS Solution (Time Limit Exceeded)
    
    /*
    Time complexity : O(2^{m+n})
    The search is repeated for each valid increasing path. 
    In the worst case we can have O(2^{m+n})calls.
    
    Space complexity : O(mn)
    For each DFS we need O(h)O(h) space used by the system stack, 
    where hh is the maximum depth of the recursion. 
    In the worst case, O(h) =O(mn).
    */
    
    
    public int naiveDfs(int[][] matrix) {
        if (matrix.length == 0) return 0;
        rowLen = matrix.length;
        colLen = matrix[0].length;
        int ans = 0;
        for (int i = 0; i < rowLen; ++i)
            for (int j = 0; j < colLen; ++j)
              ans = Math.max(ans, dfs(matrix, i, j));
        return ans;
    }
    
    private int dfs(int[][] matrix, int i, int j) {
      int ans = 0;
      for (int[] d : directions) {
          int x = i + d[0], y = j + d[1];
          if (0 <= x && x < rowLen && 0 <= y && y < colLen && matrix[x][y] > matrix[i][j])
              ans = Math.max(ans, dfs(matrix, x, y));
      }
      return ++ans;
  }
}