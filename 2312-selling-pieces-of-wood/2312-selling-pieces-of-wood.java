class Solution {
    public long sellingWood(int m, int n, int[][] prices) {
        long[][] dp = new long[m + 1][n + 1];
        for (var p : prices) {
            dp[p[0]][p[1]] = p[2];
        }
        
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                for (int h = 1; h <= i / 2; ++h) {
                    dp[i][j] = Math.max(dp[i][j], dp[h][j] + dp[i - h][j]);
                }
                for (int v = 1; v <= j / 2; ++v) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][v] + dp[i][j - v]);
                }
            }
        }
        return dp[m][n];
    }
}
