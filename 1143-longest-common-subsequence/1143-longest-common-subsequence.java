class Solution {
    
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
    
    // 2D array
    // Bottom-Up
    
    //.  a b c d e
    // a 3 2 2 2 2 0
    // c 2 2 2 1 1 0
    // e 1 1 1 1 1 0
    //.  0 0 0 0 0 0

}