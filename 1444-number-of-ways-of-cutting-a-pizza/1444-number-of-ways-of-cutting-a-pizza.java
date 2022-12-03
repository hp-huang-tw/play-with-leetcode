class Solution {
    
    // DP + Memoization
    Map<String, Long> memo = new HashMap<>();
    
    public int ways(String[] pizza, int k) {
        if (pizza == null || pizza.length == 0) return 0;
        int modulo = (int) 1e9 + 7;
        
        long res = dfs(pizza, k, 0, pizza.length - 1, 0, pizza[0].length() - 1);
        return (int) (res % modulo);
    }
    
    private long dfs(String[] pizza, int k, int rowS, int rowE, int colS, int colE) {
        if (rowS > rowE || colS > colE ||  k <= 0 ) return 0;
        
        // 0-2;0-2
        String key = rowS + "-" + rowE + ";" + colS + "-" + colE + ";" + k;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        long res = 0;

        if (k == 1) {
            res = isValid(pizza, rowS, rowE, colS, colE) ? 1 : 0;
        } else {
            for (int i = rowS; i<= rowE; i++) {
                if (isValid(pizza, rowS, i, colS, colE)) {
                    res += dfs(pizza, k - 1, i + 1, rowE, colS, colE);
                }
            }
            
            for (int i = colS; i <= colE; i++) {
                if (isValid(pizza, rowS, rowE, colS, i)) {
                    res += dfs(pizza, k - 1, rowS, rowE, i + 1, colE);
                }
            }
        }
        
        memo.put(key, res);
        return res;
    }
    
    private boolean isValid(String[] pizza, int rowS, int rowE, int colS, int colE) {
        for (int i = rowS; i <= rowE; i++) {
            for (int j = colS; j <= colE; j++) {
                if (pizza[i].charAt(j) == 'A') return true;
            }
        }
        
        return false;
    }
    
    /* preSum
    
    int r, c, MOD = 1_000_000_007;
    
    int[][] preSum;
    
    Integer[][][] dp;
    
    public int ways(String[] pizza, int k) {
        r = pizza.length;
        c = pizza[0].length();
        preSum = new int[r+1][c+1];
        dp = new Integer[r][c][k];
        for (int i = r-1; i >= 0; i--) {
            for (int j = c-1; j >= 0; j--) {
                preSum[i][j] = (pizza[i].charAt(j) == 'A' ? 1 : 0) + preSum[i+1][j] + preSum[i][j+1] - preSum[i+1][j+1];
            }
        }
        return dfs(0, 0, k-1);
    }
    private int dfs(int x, int y, int cut) {
        if (dp[x][y][cut] != null) return dp[x][y][cut];
        
        if (preSum[x][y] == 0) return 0;
        
        if (cut == 0 && preSum[x][y] > 0) return 1;
        int ans = 0;
        // Cut horizontal
        for(int i = x+1; i < r; i++) {
            if(preSum[x][y] - preSum[i][y] > 0) {
                ans = (ans + dfs(i, y, cut-1)) % MOD;
            }
        }
        // Cut vertical
        for(int j = y+1; j < c; j++) {
            if(preSum[x][y] - preSum[x][j] > 0) {
                ans = (ans + dfs(x, j, cut-1)) % MOD;
            }
        }
        dp[x][y][cut] = ans;
        return ans;
    }
    
    */
    
}