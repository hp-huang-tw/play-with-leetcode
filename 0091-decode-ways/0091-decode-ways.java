class Solution {
    public int numDecodings(String s) {
        return dfs(0, s, new int[s.length()]);
        
    }
    
    // O(n)
    private int dfs(int i, String s, int[] dp) {
        int strLen = s.length();
        if(i == strLen) return 1;
        
        if (s.charAt(i) == '0') {
            return 0;
        }
        
        if (dp[i]!=0) {
            return dp[i];
        }
        
        dp[i] = dfs(i+1, s, dp);
        
        if (i + 1 <  strLen && 
            (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i+1) >= '0' &&
             s.charAt(i+1) <= '6')) {
            dp[i] += dfs(i+2, s, dp);
        }
        return dp[i];
    }
}