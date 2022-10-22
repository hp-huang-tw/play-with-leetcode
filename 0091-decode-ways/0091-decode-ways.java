class Solution {
    private int[] dp;
    private String s;
    public int numDecodings(String s) {
        this.s = s;
        int len = s.length();
        dp = new int[len];
        dp[len - 1] = 1;
        return dfs(0);
        
    }
    
    private int dfs(int i) {
        int strLen = s.length();
        if(i == strLen) return 1;
        
        if (s.charAt(i) == '0') {
            return 0;
        }
        
        if (dp[i]!=0) {
            return dp[i];
        }
        
        int res = dfs(i+1);
        
        if (i + 1 <  strLen && 
            (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i+1) >= '0' &&
             s.charAt(i+1) <= '6')) {
            res += dfs(i+2);
        }
        
        dp[i] = res;
        return res;
    }
}