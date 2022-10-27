class Solution {
    // Bottom-Up
    // TC: O(m*n), SC: O(m*n)
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length(), len2 = text2.length();
        
        int[][] dp = new int[len1+1][len2+1];
        
        for (int i = len1 - 1; i > -1; i--) {
            for (int j = len2 -1; j > -1; j--) {
                if (text1.charAt(i) ==  text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i+1][j+1];
                } else {
                    dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        
        return dp[0][0];
    }
}